(ns scraftisan.main
  (:require [clojure.string :as str]
            [hiccup2.core :as hiccup2]
            [scraftisan.applications :as appl]
            [scraftisan.astronomy :as astronomy]
            [scraftisan.stars :as stars]
            [scraftisan.animation :as anim]
            [scraftisan.color :as color]
            [scraftisan.conclusion :as conclusion]
            [scraftisan.freehand :as freehand]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.intro :as intro]
            [scraftisan.iconography :as ico]
            [scraftisan.better :as better]
            [scraftisan.diagrams :as diagrams]
            [scraftisan.layout :as layout]
            [scraftisan.visualizations :as visualizations]
            [scraftisan.marcup :as marcup]
            [scraftisan.paths :as paths]
            [scraftisan.groups :as groups]
            [scraftisan.principles :as principles]
            [scraftisan.art :as art]
            [scraftisan.util :as util]
            [scraftisan.how :as how]
            [scraftisan.workflow :as workflow]
            [scraftisan.why :as why]))

;; TODO: we need to set up the slide viewboxes
;; TODO: can we make an interactive way of positioning slides and path points?
;; TODO: can we have animations within slides?
;; TODO: some slides might want to be absolute?

(def intro
  (util/arrange [intro/slides -500 0]
                [stars/slides 0 0]
                [astronomy/slides -1000 -500]))

(def inspire
  (util/arrange [appl/slides 0 0]
                [anim/slides 0 900]
                [why/slides 0 -500]))

(def how-to-do-it
  (util/arrange [how/slides 0 0]
                [paths/slides -1000 300]
                [groups/slides -2000 600]
                [color/slides 2500 600]
                [fo/slides 3000 600]
                [marcup/slides 3500 600]
                [workflow/slides 3500 300]))

(def a-bit-about-diagrams
  (util/arrange [better/slides 0 0]
                [visualizations/slides 0 300]
                [diagrams/slides 0 600]
                [layout/slides 0 9000]))

(def a-bit-about-images
  (util/arrange [art/slides 0 0]
                [principles/slides -3000 0]
                [freehand/slides -6000 0]
                [ico/slides 0 1200]))

(def conclusion
  (util/arrange []
                []
                [conclusion/slides 0 0]))

(defn slide-tree []
  (util/arrange [intro 0 0]
                [inspire 500 0]
                [how-to-do-it -2500 300]
                [a-bit-about-diagrams -2500 2000]
                [a-bit-about-images 3000 3000]
                [conclusion 500 1200]))

(defn path [t [x y & more]]
  (str "M" x " " y " " t (str/join " " more)))

(defn alter-attrs [hiccup f]
  (cond (vector? hiccup)
        (let [[tag & [attrs & more :as children]] hiccup]
          (if (map? attrs)
            (into [tag (f attrs)] (map #(alter-attrs % f)) more)
            (into [tag] (map #(alter-attrs % f)) children)))

        (seq? hiccup)
        (map #(alter-attrs % f) hiccup)

        :else
        hiccup))

(defn to [x y]
  (str "translate(" x "," y ")"))

(defn slide-id [i]
  (format "slide%03d" i))

(defn slide-attrs []
  (let [z 50]
    (map-indexed
      (fn [i [x y]]
        {:id (slide-id i)
         ;; TODO: not all slides are absolute
         #_#_:transform (str (to (* x z) (* y z)) " scale(0.5,0.5)")})
      ;; TODO: groups, TODO: don't need it?
      (cycle (partition-all 2 (filter number? principles/hummi-path))))))

(defn setup-slides [hiccup]
  (let [a (atom (slide-attrs))
        take-one! #(if-let [[head & more] @a]
                     (do (reset! a more) head)
                     (throw (ex-info "Not enough slide attrs"
                                     {:id ::not-enough-slide-attrs})))]
    (alter-attrs hiccup
                 (fn [attrs]
                   (if (contains? attrs :data-title)
                     (merge attrs (take-one!))
                     attrs)))))

(defn walk-hiccup
  "Returns a depth first sequence of all hiccup nodes [tag attr? & children]."
  [hiccup]
  (let [walk (fn walk [node]
               (lazy-seq
                 (cond (vector? node)
                       (cons node
                             (let [[tag & [attrs & more] :as children] node]
                               (if (map? attrs)
                                 (mapcat walk more)
                                 (mapcat walk children))))

                       (seq? node)
                       (mapcat walk node))))]
    (walk hiccup)))

(defn slides-seq [hiccup]
  (->> (walk-hiccup hiccup)
       (filter (fn [[tag attrs]]
                 (and (map? attrs)
                      (contains? attrs :data-title))))))

(defn tractionize [[tag attrs & hiccup]]
  (assert (= tag :svg))
  (assert (map? attrs))
  (into [tag attrs
         [:script {:xmlns:xlink "http://www.w3.org/1999/xlink"
                   :href        "traction.js"
                   :type        "text/ecmascript"}]
         ;; need xmlns for remote stylesheets in svg
         [:link {:xmlns  "http://www.w3.org/1999/xhtml"
                 :rel    "stylesheet"
                 :href   "https://fonts.googleapis.com/css2?family=Baloo+2:wght@400&display=swap"
                 :as     "style"
                 :onload "this.onload=null;this.rel='stylesheet'"}]
         #_[:script {:type "text/ecmascript"} "setTimeout(() => location.reload(), 2000)"]
         [:steps {:xmlns "http://chouser.n01se.net/traction/config"}
          [:init
           [:set {:duration "1000"}]]
          ;; TODO: how many steps are there? need to count the actual slides...
          (for [i (range (count (slides-seq hiccup)))]
            [:step {:view (slide-id i)}])]]
        hiccup))

(defn html []
  (->> (slide-tree)
       (setup-slides)
       (util/svg {:style {:background  (color/palette 12)
                          :font-family "'Baloo 2'"}})
       (tractionize)
       (hiccup2/html)
       (str)))

(defn -main [& args]
  (spit "scraftisan.svg" (html)))

(comment
  (-main)

  (defonce reload
    (future
      (while true
        (spit "scraftisan.svg" (html))
        (Thread/sleep 1000))))

  (spit "sketches/night-sky.svg" (hiccup2/html stars/night-sky-standalone)))
