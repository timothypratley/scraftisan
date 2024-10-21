(ns scraftisan.icons
  (:require [scraftisan.color :as color]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.util :as util]))

(def scicloj-icons
  [:g {:data-title ""}
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

(def favicon
  [:g {:data-title "favicon"}
   [:circle {:r 128 :fill (color/palette 1)}]])
;;(util/save "favicon.svg" (svg/svg favicon))

(def scicloj-palette
  [:g {:data-title ""}
   (fo/fo {}
          [:div {:style "align-items:center;display:grid;gap:10;grid-template-columns:repeat(3, 1fr);justify-content:center;text-align:center;"}
           [:div
            [:div {:style "background-color:#FFFFFF;color:black;padding:10;"}
             [:div "0"]
             [:div "#FFFFFF"]
             [:div "white background"]]]
           [:div [:div {:style "background-color:#62B132;color:white;padding:10;"}
                  [:div "1"]
                  [:div "#62B132"]
                  [:div "Clojure green"]]]
           [:div [:div {:style "background-color:#5881D8;color:white;padding:10;"}
                  [:div "2"]
                  [:div "#5881D8"]
                  [:div "Clojure blue"]]]
           [:div [:div {:style "background-color:#91DC47;color:black;padding:10;"}
                  [:div "3"]
                  [:div "#91DC47"]
                  [:div "Clojure light green"]]]
           [:div [:div {:style "background-color:#8FB5FE;color:black;padding:10;"}
                  [:div "4"]
                  [:div "#8FB5FE"]
                  [:div "Clojure light blue"]]]
           [:div [:div {:style "background-color:#F26767;color:white;padding:10;"}
                  [:div "5"]
                  [:div "#F26767"]
                  [:div "coral red"]]]
           [:div [:div {:style "background-color:#FFCD52;color:black;padding:10;"}
                  [:div "6"]
                  [:div "#FFCD52"]
                  [:div "golden yellow"]]]
           [:div [:div {:style "background-color:#A86F40;color:white;padding:10;"}
                  [:div "7"]
                  [:div "#A86F40"]
                  [:div "chocolate brown"]]]
           [:div [:div {:style "background-color:#E0E0E0;color:black;padding:10;"}
                  [:div "8"]
                  [:div "#E0E0E0"]
                  [:div "light gray"]]]
           [:div [:div {:style "background-color:#808080;color:white;padding:10;"}
                  [:div "9"]
                  [:div "#808080"]
                  [:div "medium gray"]]]
           [:div [:div {:style "background-color:#2F4179;color:white;padding:10;"}
                  [:div "10"]
                  [:div "#2F4179"]
                  [:div "midnight blue"]]]])])

(def recommendations
  [:g {:data-title ""}
   (fo/fo {}
          [:div {:style "align-items:center;display:grid;gap:10;grid-template-columns:repeat(7, 1fr);justify-content:center;text-align:center;"}
           [:div [:div [:h4 "background"]
                  [:div [:svg {:width 64
                               :fill  "none" :stroke-linecap "round" :stroke-linejoin "round" :stroke-width "31" :viewBox "-128 -128 256 256" :xmlns "http://www.w3.org/2000/svg"} [:circle {:cx "0" :cy "0" :fill "#FFFFFF" :r "128" :stroke "none"}]]]]]
           [:div [:strong "+"]]
           [:div [:div [:h4 "parens"]
                  [:div [:svg {:width 64
                               :fill "none" :stroke-linecap "round" :stroke-linejoin "round" :stroke-width "31" :viewBox "-128 -128 256 256" :xmlns "http://www.w3.org/2000/svg"} [:g {:stroke-linecap "butt"} [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128" :stroke "#62B132"}]
                                                                                                                                                                                   [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128" :stroke "#5881D8"}]]]]]]
           [:div [:strong "+"]]
           [:div [:div [:h4 "heart"]
                  [:div [:svg {:width 64
                               :fill "none" :stroke-linecap "round" :stroke-linejoin "round" :stroke-width "31" :viewBox "-128 -128 256 256" :xmlns "http://www.w3.org/2000/svg"} [:g#heart {:transform "translate(-120,-120) scale(10)"} [:path {:d "M 12.0 7.2 C 10.5 5.6 8.1 5.2 6.3 6.7 C 4.5 8.1 4.2 10.6 5.7 12.4 L 12.0 18.3 L 18.3 12.4 C 19.7 10.6 19.5 8.1 17.7 6.7 C 15.8 5.2 13.4 5.6 12.0 7.2 Z" :fill "#F26767"}]]]]]]
           [:div [:strong "="]]
           [:div [:div [:h4 "kindly"]
                  [:div [:svg {:width 64
                               :fill "none" :stroke-linecap "round" :stroke-linejoin "round" :stroke-width "31" :viewBox "-128 -128 256 256" :xmlns "http://www.w3.org/2000/svg"} [:circle {:cx "0" :cy "0" :fill "#FFFFFF" :r "128" :stroke "none"}]
                         [:g {:stroke-linecap "butt"} [:path {:d "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128" :stroke "#62B132"}]
                          [:path {:d "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128" :stroke "#5881D8"}]]
                         [:g#heart {:transform "translate(-120,-120) scale(10)"} [:path {:d "M 12.0 7.2 C 10.5 5.6 8.1 5.2 6.3 6.7 C 4.5 8.1 4.2 10.6 5.7 12.4 L 12.0 18.3 L 18.3 12.4 C 19.7 10.6 19.5 8.1 17.7 6.7 C 15.8 5.2 13.4 5.6 12.0 7.2 Z" :fill "#F26767"}]]]]]]])])

(def slides
  (util/arrange "Icons"
                [recommendations 400 0]
                [scicloj-palette 1200 0]
                [scicloj-icons 400 600]))
