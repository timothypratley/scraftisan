(ns scraftisan.main
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [hiccup2.core :as hiccup2]
            [scraftisan.color :as color]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.marcup :as marcup]
            [scraftisan.principles :as principles]
            [scraftisan.svg-concepts :as svg]))

;; TODO: we need to set up the slide viewboxes
;; TODO: can we make an interactive way of positioning slides and path points?
;; TODO: can we have animations within slides?

(defn slide-tree []
  [:g {:data-title "overview"}
   svg/slides
   color/slides
   fo/slides
   marcup/slides
   principles/slides])

(defn path [t [x y & more]]
  (str "M" x " " y " " t (str/join " " more)))

(def slide-path
  (apply concat (for [x [-1 0 1 2]
                      y [-1 0 1 2]]
                  [x y])))

(comment
  (svg/svg [:path {:stroke (color/palette 11)
                   :fill   "none"
                   :d      (path \L (map #(* % 10) slide-path))}]))

(defn alter-attrs [hiccup f]
  (cond (vector? hiccup)
        (let [[tag & [attrs & more] :as children] hiccup]
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
        {:id        (slide-id i)
         :transform (str (to (* x z) (* y z)) " scale(0.5,0.5)")})
      (partition-all 2 slide-path))))

(comment
  (slide-attrs))

(defn setup-slides [hiccup]
  (let [a (atom (slide-attrs))
        take-one! #(if-let [[head & more] @a]
                     (do (reset! a more) head)
                     (throw (ex-info "Not enough slide attrs"
                                     {:id ::not-enough-slide-attrs})))]
    (alter-attrs hiccup (fn [attrs]
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
                   :xlink:href  "traction.js"
                   :type        "text/ecmascript"}]
         [:steps {:xmlns "http://chouser.n01se.net/traction/config"}
          [:init
           [:set {:duration "1000"}]]
          ;; TODO: how many steps are there? need to count the actual slides...
          (for [i (range (count (slides-seq hiccup)))]
            [:step {:view (slide-id i)}])]]
        hiccup))

(defn html []
  (hiccup2/html (tractionize (svg/svg (setup-slides (slide-tree))))))

(defn -main [& args]
  (spit "scraftisan.svg" (html)))
