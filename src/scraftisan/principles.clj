(ns scraftisan.principles
  (:require [clojure.string :as str]
            [scraftisan.color :as color]))

(def gstalt-proximity
  [:g {:stroke (color/palette 11)}
   #_[:rect {:fill   (palette 10)
             :x      4
             :y      4
             :rx     4
             :width  120
             :height 120}]
   [:g {:fill (color/palette 1)}
    [:circle {:cx -64
              :cy -64
              :r  16}]
    [:circle {:cx 32
              :cy 32
              :r  16}]
    [:circle {:cx 96
              :cy 32
              :r  16}]
    [:circle {:cx 96
              :cy 96
              :r  16}]]])

(def hummi-path
  ['M 19 85
   ;; under-tail
   'c 0 0 -1 1 1 0 0 0 8 -5 11 -7.5 0 0 5 -5 10 -5
   ;; body
   10 0 30 -15 30 -35
   ;; chin
   0 0 0 -10 4 -10
   ;; beak
   0 0 10 -2.5 24 -2 0 0 -10 -0.5 -20 -0.5
   ;; head
   -5 0 -5 -1 -10 -3.5 -15 -5 -12 18 -18 18
   ;; over-wing
   -5 0 -8 -8 -50 -13
   ;; under-wing
   30 23 45 25 45 25
   ;; over-tail
   0 0 -6 5 -12 15 0 0 -7 10 -15 18.5])

(defn rand-hummi []
  (let [scale (+ (rand 2) 0.1)
        flip (zero? (rand-int 2))]
    [:g {:transform (str "translate(" (- (rand-int 128) 96) "," (- (rand-int 128) 96) ") scale(" (if flip (- scale) scale) "," scale ")")}
     [:path {:fill (color/palette (inc (rand-int (dec (count color/palette)))))
             :d    (str/join " " hummi-path)}]]))

(def gstalt-similarity
  (into [:g] (repeatedly 20 rand-hummi)))

(def gstalt-continuity
  [:path {:d                (str/join " " hummi-path)
          :fill             "none"
          :stroke           (color/palette 1)
          :stroke-width     5
          :stroke-dasharray [5]}])

(def gstalt-closure
  [:path {:d            (str/join " " (take 70 hummi-path))
          :fill         "none"
          :stroke       (color/palette 1)
          :stroke-width 5}])

(def gstalt-symmetry
  (into [:g]
        (for [x [-1 1]
              y [-1 1]]
          [:path {:transform (str "scale(" x "," y ")")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 3)}])))

(def gstalt-figure-ground
  [:path {:transform (str "scale(5,5) translate(" -48 "," -48 ")")
          :d         (str/join " " hummi-path)
          :fill      (color/palette 2)}])

(def gstalt-common-fate
  (into [:g]
        (for [[x y] [[-96 -64] [-32 0] [16 -96] [-64 -32] [0 16]]]
          [:path {:transform (str "translate(" x "," y ") scale(0.5,0.5)")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 1)}])))

(def slides
  [:g {:data-title "design principles"}
   gstalt-figure-ground
   gstalt-symmetry
   gstalt-similarity
   gstalt-proximity
   gstalt-closure
   gstalt-common-fate
   gstalt-continuity])
