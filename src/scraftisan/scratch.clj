(ns scraftisan.scratch
  (:require [clojure.string :as str]
            [hiccup.core :as hiccup]
            [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind]))

(def palette
  ["#FCFFE0"
   "#D0F040"
   "#E6E6FA"
   "#D0F7FF"
   "#FCECC5"
   "#FCE2F7"
   "#E0FFD0"
   "#F0D0E0"
   "#40D0A0"
   "#FF8080"
   "#F0F0C8"
   "#AFA050"])

(defn svg [& body]
  (kind/hiccup
    (into [:svg {:height  256
                 :width   256
                 :viewBox [-127 -127 256 256]
                 :xmlns   "http://www.w3.org/2000/svg"}
           [:rect {:fill   (palette 0)
                   :stroke (palette 11)
                   :x      -127
                   :y      -127
                   :width  256
                   :height 256
                   :rx     4}]]
          body)))

(defn palette-view []
  (let [w 32 h 32]
    (->> (partition-all 3 palette)
         (map-indexed (fn [y row]
                        (->> (map-indexed (fn [x color]
                                            [:path {:transform (str "translate(" (* (- x 1) w 2) " " (* (- y 1) h 2) ")")
                                                    :fill      color
                                                    :d         (str/join " " ['M (- w) (- h)
                                                                              'L w (- h) w h (- w) h
                                                                              'Z])}])
                                          row)
                             (into [:g]))))
         (into [:g]))))

(svg (palette-view))

(defn gstalt-proximity []
  [:g {:stroke (palette 11)}
   #_[:rect {:fill   (palette 10)
             :x      4
             :y      4
             :rx     4
             :width  120
             :height 120}]
   [:g {:fill (palette 1)}
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

(svg (gstalt-proximity))

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

#_(svg [:path {:d    (str/join " " hummi-path)
               :fill (palette 1)}])

(defn rand-hummi []
  (let [scale (+ (rand 2) 0.1)
        flip (zero? (rand-int 2))]
    [:g {:transform (str "translate(" (- (rand-int 128) 96) "," (- (rand-int 128) 96) ") scale(" (if flip (- scale) scale) "," scale ")")}
     [:path {:fill (palette (inc (rand-int (dec (count palette)))))
             :d    (str/join " " hummi-path)}]]))

(defn gstalt-similarity []
  (into [:g]
        (repeatedly 20 rand-hummi)))

(svg (gstalt-similarity))

(defn gstalt-continuity []
  [:path {:d                (str/join " " hummi-path)
          :fill             "none"
          :stroke           (palette 1)
          :stroke-width     5
          :stroke-dasharray [5]}])

(svg (gstalt-continuity))

(defn gstalt-closure []
  [:path {:d            (str/join " " (take 70 hummi-path))
          :fill         "none"
          :stroke       (palette 1)
          :stroke-width 5}])

(svg (gstalt-closure))

(defn gstalt-symmetry []
  (into [:g]
        (for [x [-1 1]
              y [-1 1]]
          [:path {:transform (str "scale(" x "," y ")")
                  :d         (str/join " " hummi-path)
                  :fill      (palette 3)}])))

(svg (gstalt-symmetry))

(defn gstalt-figure-ground []
  [:path {:transform (str "scale(5,5) translate(" -48 "," -48 ")")
          :d         (str/join " " hummi-path)
          :fill      (palette 2)}])

(svg (gstalt-figure-ground))

(defn gstalt-common-fate []
  (into [:g]
        (for [[x y] [[-96 -64] [-32 0] [16 -96] [-64 -32] [0 16]]]
          [:path {:transform (str "translate(" x "," y ") scale(0.5,0.5)")
                  :d         (str/join " " hummi-path)
                  :fill      (palette 1)}])))

(svg (gstalt-common-fate))

(def slides
  [[[-1 -1] gstalt-figure-ground]
   [[-1 0] gstalt-symmetry]
   [[-1 1] gstalt-similarity]
   [[0 -1] gstalt-proximity]
   [[0 0] gstalt-closure]
   [[0 1] gstalt-common-fate]
   [[1 -1] gstalt-continuity]])

(def all-slides
  (let [z 300
        s "scale(0.2,0.2)"
        tr (fn [x y] (str "translate(" (* x z) "," (* y z) ")"))]
    (into [:g]
          (for [[[x y] f] slides]
            [:g {:transform (str s " " (tr x y))} (f)]))))

(svg all-slides)

(spit "scraftisan.svg" (hiccup2/html (svg all-slides)))