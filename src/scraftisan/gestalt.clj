(ns scraftisan.gestalt
  (:require [clojure.string :as str]
            [scraftisan.color :as color]
            [scraftisan.util :as util]))

(defn title [t]
  (util/fo {:style {:color      "black"
                    :background (color/palette 0)
                    :font-size  "25px"}}
           t))

(def proximity
  [:g {:data-title ""}
   [:rect {:width  256
           :height (+ 64 256)
           :stroke "none"
           :fill   (color/palette 0)}]
   [:g {:transform "translate(96,192)"
        :fill      (color/palette 1)}
    [:circle {:cx -64
              :cy -64
              :r  16}]
    [:circle {:cx 48
              :cy 48
              :r  16}]
    [:circle {:cx 96
              :cy 48
              :r  16}]
    [:circle {:cx 96
              :cy 96
              :r  16}]]
   (title "Proximity")])

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
  (let [scale (+ (util/srand) 0.1)
        flip (zero? (util/srand-int 2))
        x (+ (util/srand-int 96) 16)
        y (+ (util/srand-int 96) 32)]
    [:g {:transform (str "translate(" x "," y ") scale(" (if flip (- scale) scale) "," scale ")")}
     [:path {:fill (color/palette (inc (util/srand-int (dec (count color/palette)))))
             :d    (str/join " " hummi-path)}]]))

(def similarity
  [:g {:data-title ""}
   [:rect {:width  256
           :height (+ 64 256)
           :stroke "none"
           :fill   (color/palette 0)}]
   [:g {:transform "translate(64,64)"
        :stroke    "none"}
    (util/with-seed (repeatedly 20 rand-hummi))]
   (title "Similarity")])

(def continuity
  [:g {:data-title ""}
   [:g {:transform        "translate(0,32) scale(2)"
        :fill             "none"
        :stroke           (color/palette 0)
        :stroke-width     5
        :stroke-dasharray [5]}
    [:path {:d "M 0 64 L 128 64"}]
    [:path {:d "M 0 96 L 128 32"}]]
   (title "Continuity")])

(def closure
  [:g {:data-title ""}
   [:g {:transform    "translate(64,64)"
        :stroke-width 15
        :fill         "none"
        :stroke       (color/palette 0)}
    [:path {:d "M 128 128 A 80 70 0 0 0 0 32"}]
    [:path {:d "M -32 64 A 80 70 0 0 0 96 160"}]]
   (title "Closure")])

(def symmetry
  [:g {:data-title ""}
   [:g {:transform "translate(128,192)"}
    [:rect {:x      -128
            :width  256
            :height 128
            :stroke "none"
            :fill   (color/palette 3)}]
    (for [x [-1 1]
          y [-1 1]]
      [:path {:transform (str "scale(" x "," y ") translate(0,-96)")
              :d         (str/join " " hummi-path)
              :fill      (color/palette 0)}])]
   (title "Symmetry")])

(def figure-ground
  [:g {:data-title ""}
   [:g {:transform "translate(0,48)"}
    [:path {:transform (str "scale(3,3)")
            :d         (str/join " " hummi-path)
            :fill      (color/palette 2)
            :stroke    "none"}]]
   (title "Figure-ground")])

(def common-fate
  [:g {:data-title ""}
   [:g {:transform "translate(220,220) scale(2.5)"}
    (for [[x y]
[[-96 -64]
[-32 0]
[8 -72]
[-64 -32]
[0 16]]]
      [:path {:transform (str "translate(" x "," y ") scale(-0.4,0.4)")
              :d         (str/join " " hummi-path)
              :fill      (color/palette 0)}])]
   (title "Common-fate")])

(def slides
  [:g {:stroke-width 2
       :stroke       (color/palette 11)
       :fill         (color/palette 10)}
   (util/arrange "Gestalt"
                 [proximity 400 0]
                 [closure 800 0]
                 [continuity 1200 0]
                 [figure-ground 400 400]
                 [symmetry 800 400]
                 [similarity 1200 400]
                 [common-fate 1200 800])])
