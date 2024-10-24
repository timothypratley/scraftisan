(ns scraftisan.main
  (:require [clojure.string :as str]
            [hiccup2.core :as hiccup2]
            [scraftisan.aliens :as aliens]
            [scraftisan.applications :as appl]
            [scraftisan.astronomy :as astronomy]
            [scraftisan.stars :as stars]
            [scraftisan.animation :as anim]
            [scraftisan.color :as color]
            [scraftisan.conclusion :as conclusion]
            [scraftisan.freehand :as freehand]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.intro :as intro]
            [scraftisan.icons :as icons]
            [scraftisan.think :as think]
            [scraftisan.communicate :as communicate]
            [scraftisan.layout :as layout]
            [scraftisan.visualize :as visualize]
            [scraftisan.marcup :as marcup]
            [scraftisan.paths :as paths]
            [scraftisan.groups :as groups]
            [scraftisan.gestalt :as gestalt]
            [scraftisan.beauty :as beauty]
            [scraftisan.util :as util]
            [scraftisan.how :as how]
            [scraftisan.workflow :as workflow]
            [scraftisan.why :as why]))

;; TODO: we need to set up the slide viewboxes
;; TODO: can we make an interactive way of positioning slides and path points?
;; TODO: can we have animations within slides?
;; TODO: some slides might want to be absolute?

(def intro
  (util/arrange "Stars"
                [intro/slides -2000 0]
                [stars/slides 0 0]))

(def inspire
  (util/arrange "Inspiration"
                [aliens/octo1 0 200]
                [appl/slides 400 0]
                [anim/slides 2000 0]
                [why/slides 2000 1000]
                [astronomy/slides -2000 300]))

(def how-to-svg
  (util/arrange "How To SVG"
                [aliens/octo2 0 200]
                [how/slides 400 0]
                [groups/slides -1000 300]
                [paths/slides -2500 600]
                [color/slides 0 1500]
                [fo/slides 2000 300]
                [marcup/slides 2000 800]
                [workflow/slides 2000 1300]))

(def a-bit-about-diagrams
  (util/arrange "Diagrams"
                [aliens/octo3 0 200]
                [think/slides 400 0]
                [visualize/slides 400 500]
                [communicate/slides 400 1400]
                [layout/slides 400 2000]))

(def a-bit-about-images
  (util/arrange "Art"
                [aliens/octo4 0 200]
                [beauty/slides 400 0]
                [gestalt/slides 400 1000]
                [icons/slides 1000 2500]
                [freehand/slides 1000 4200]))

(def conclusion
  (util/arrange "Conclusion"
                [aliens/cute 0 200]
                [conclusion/slides 0 0]))

(defn slide-tree []
  (util/with-seed
    (util/arrange "Stars"
                  [intro 0 0]
                  [inspire 2000 -1000]
                  [how-to-svg -3500 1000]
                  [a-bit-about-diagrams -1500 5500]
                  [a-bit-about-images 2500 3000]
                  [conclusion -2000 3500])))

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

(defn slide-id [i]
  (str "step" i))

(defn setup-slides [hiccup]
  (let [a (atom 0)]
    (alter-attrs hiccup (fn [attrs]
                          (if (contains? attrs :data-title)
                            (assoc attrs :id (slide-id (swap! a inc)))
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
          [:init [:set {:duration "1000"}]]
          (for [i (range (count (slides-seq hiccup)))]
            [:step {:view (slide-id (inc i))}])
          [:step {:view (slide-id 4)}]
          [:step {:view (slide-id 32)}]
          [:step {:view (slide-id 1)}]]]
        [:g hiccup
         ;; if you want to see the viewboxes
         #_[:rect#rect {:width "300" :height "150" :fill "none" :stroke "red" :stroke-width "20"}]]))

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

(defn rewrite []
  (require '[scraftisan.main] :reload-all)
  (-main))

(comment
  (rewrite)

  (defonce reload
    (future
      (while true
        (spit "scraftisan.svg" (html))
        (Thread/sleep 1000))))

  (spit "sketches/night-sky.svg" (hiccup2/html stars/night-sky-standalone)))
