(ns scraftisan.principles
  (:require [clojure.string :as str]
            [scraftisan.color :as color]
            [scraftisan.util :as util]))

(def proximity
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

(def similarity
  (into [:g {:data-title ""}]
        (repeatedly 20 rand-hummi)))

(def continuity
  [:g {:data-title ""}
   [:path {:d                (str/join " " hummi-path)
           :fill             "none"
           :stroke           (color/palette 1)
           :stroke-width     5
           :stroke-dasharray [5]}]])

(def closure
  [:g {:data-title ""}
   [:path {:d            (str/join " " (take 70 hummi-path))
           :fill         "none"
           :stroke       (color/palette 1)
           :stroke-width 5}]])

(def symmetry
  (into [:g {:data-title ""}]
        (for [x [-1 1]
              y [-1 1]]
          [:path {:transform (str "scale(" x "," y ")")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 3)}])))

(def figure-ground
  [:g {:data-title ""}
   [:path {:transform (str "scale(5,5) translate(" -48 "," -48 ")")
           :d         (str/join " " hummi-path)
           :fill      (color/palette 2)}]])

(def common-fate
  (into [:g {:data-title ""}]
        (for [[x y] [[-96 -64] [-32 0] [16 -96] [-64 -32] [0 16]]]
          [:path {:transform (str "translate(" x "," y ") scale(0.5,0.5)")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 1)}])))

(def nand
  [:g {:data-title ""}
   [:circle {:r 10}]])

(def icons
  [:g {:data-title ""
       :transform  "translate(-1000,1500)"}
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(135,0)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:circle {:cx "0", :cy "0", :fill "#808080", :id "gray ball of clay", :r "64.0"}]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(405,0)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:id "heart", :transform "translate(-120,-120) scale(10)"}
     [:path {:d "M 12.0 7.2 C 10.5 5.6 8.1 5.2 6.3 6.7 C 4.5 8.1 4.2 10.6 5.7 12.4 L 12.0 18.3 L 18.3 12.4 C 19.7 10.6 19.5 8.1 17.7 6.7 C 15.8 5.2 13.4 5.6 12.0 7.2 Z", :fill "#F26767"}]]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(0,230)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:id "net"}
     [:g {:stroke "#E0E0E0", :stroke-width "4"}
      [:g
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "64"}]]
      [:g
       [:line {:x1 "0", :x2 "64", :y1 "-64", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-64", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-32", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-32", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "0", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "0", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "32", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "32", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "64", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "64", :y2 "16"}]]]
     [:g {:fill "#FFCD52"}
      [:circle {:cx "-64", :cy "-32", :r "14"}]
      [:circle {:cx "-64", :cy "0", :r "14"}]
      [:circle {:cx "-64", :cy "32", :r "14"}]]
     [:g {:fill "#A86F40"}
      [:circle {:cx "0", :cy "-64", :r "14"}]
      [:circle {:cx "0", :cy "-32", :r "14"}]
      [:circle {:cx "0", :cy "0", :r "14"}]
      [:circle {:cx "0", :cy "32", :r "14"}]
      [:circle {:cx "0", :cy "64", :r "14"}]]
     [:g {:fill "#F26767"}
      [:circle {:cx "64", :cy "-16", :r "14"}]
      [:circle {:cx "64", :cy "16", :r "14"}]]]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(540,230)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:id "tilde", :stroke "#FFCD52", :stroke-linecap "square", :stroke-width "20"}
     [:path {:d "M -55 55 L -55 -55 -18 -55 -18 55 18 55 18 -55 55 -55 55 55", :stroke "#A86F40", :stroke-width "30"}]
     [:path {:d "M -55 55 L -55 -55 -18 -55 -18 55 18 55 18 -55 55 -55 55 55"}]
     [:path {:d "M -67 65 L -43 65", :stroke "#A86F40", :stroke-linecap "round", :stroke-width "10"}]
     [:path {:d "M 67 65 L 43 65", :stroke "#A86F40", :stroke-linecap "round", :stroke-width "10"}]
     [:path {:d "M -30 -20 L -6 -20", :stroke "#A86F40", :stroke-linecap "round", :stroke-width "10"}]
     [:path {:d "M 30 20 L 6 20", :stroke "#A86F40", :stroke-linecap "round", :stroke-width "10"}]]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(135,460)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:fill "#8FB5FE", :id "robot head", :stroke "#8FB5FE"}
     [:path {:d "M -64 -20 L 64 -20 55 40 -55 40 z", :stroke-width "20"}]
     [:line {:stroke-width "10", :x1 "0", :x2 "0", :y1 "0", :y2 "-64"}]
     [:circle {:cx "0", :cy "-64", :r "10", :stroke "none"}]
     [:g {:fill "#2F4179", :stroke "#2F4179", :stroke-width "10"}
      [:circle {:cx "-32", :cy "0", :r "8"}]
      [:circle {:cx "32", :cy "0", :r "8"}]
      [:line {:x1 "-16", :x2 "16", :y1 "30", :y2 "30"}]]]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(405,460)"}
    [:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:id "grid of data", :stroke "#2F4179", :stroke-width "8"}
     [:rect {:fill "#E0E0E0", :height "100.0", :width "150.0", :x "-75.0", :y "-50.0"}]
     [:line {:x1 "-75.0", :x2 "75.0", :y1 "-50.0", :y2 "-50.0"}]
     [:line {:x1 "-75.0", :x2 "75.0", :y1 "-25.0", :y2 "-25.0"}]
     [:line {:x1 "-75.0", :x2 "75.0", :y1 "0.0", :y2 "0.0"}]
     [:line {:x1 "-75.0", :x2 "75.0", :y1 "25.0", :y2 "25.0"}]
     [:line {:x1 "-75.0", :x2 "75.0", :y1 "50.0", :y2 "50.0"}]
     [:line {:x1 "-75.0", :x2 "-75.0", :y1 "-50.0", :y2 "50.0"}]
     [:line {:x1 "-25.0", :x2 "-25.0", :y1 "-50.0", :y2 "50.0"}]
     [:line {:x1 "25.0", :x2 "25.0", :y1 "-50.0", :y2 "50.0"}]
     [:line {:x1 "75.0", :x2 "75.0", :y1 "-50.0", :y2 "50.0"}]]]
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31", :transform "translate(270,230)"}
    [:circle {:cx "0", :cy "0", :fill "#2F4179", :r "128", :stroke "none"}]
    [:g {:stroke-linecap "butt"}
     [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128", :stroke "#62B132"}]
     [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128", :stroke "#5881D8"}]]
    [:g {:fill "#FFCD52", :id "north star"}
     [:path {:d "M 0 -80 L 8 0 0 80 -8 0 Z"}]
     [:path {:d "M -80 0 L 0 8 80 0 0 -8 Z"}]
     [:path {:d "M -40.0 -40.0 L -8 0 40.0 40.0 8 0 Z"}]
     [:path {:d "M -40.0 40.0 L -8 0 40.0 -40.0 8 0 Z"}]]]])

(def slides
  (util/arrange [figure-ground 0 0]
                [symmetry 200 0]
                [similarity 400 0]
                [proximity 600 0]
                [closure 800 0]
                [common-fate 0 300]
                [continuity 200 300]
                [nand 400 300]
                [icons 0 600]))
