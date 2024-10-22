(ns scraftisan.applications
  (:require [scraftisan.color :as color]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.icons :as icons]
            [scraftisan.util :as util]
            [scraftisan.inheritance :as inheritance]
            [hiccup2.core :refer [raw]]))

(def plantuml
  [:g {:data-title ""
       :transform  "scale(0.3, 0.3)"}
   [:foreignObject {:width 500 :height 400 :transform "translate(0, 100)"}
    [:style "
.ace_line {
    color: #fff;
    white-space: pre;
    font-family: monospace;
}
.ace_keyword { color: #aaf }
"]
    [:div {:xmlns "http://www.w3.org/1999/xhtml"}
     (raw (slurp "images/plantuml-src.html"))]]
   [:image {:href "images/plantuml.svg" :width 313 :height 572 :transform "translate(500,0)"}]])

(def documentation
  (util/arrange "Docs"
                [plantuml 400 0]
                [inheritance/diagram 400 500]))

(def icons
  (util/arrange "Icons"
                [[:g {:transform "scale(0.2,0.2)"} icons/scicloj-icons] 400 0]))

(def web-app
  [:g {:data-title ""}
   [:circle {:cx 25 :cy 75 :r 100 :fill (color/palette 4)}]
   [:foreignObject {:width     "50"
                    :height    "50"
                    :style     {:overflow "visible"}}
    [:animateTransform {:attributeName "transform"
                        :attributeType "XML"
                        :type          "rotate"
                        :from          "0 25 75"
                        :to            "360 25 75"
                        :dur           "20s"
                        :repeatCount   "indefinite"}]
    [:div {:xmlns "http://www.w3.org/1999/xhtml"
           :width "200px"}
     [:div
      [:h3 "Zany™"]
      [:input {:size 5}]
      [:button "Sign up"]]]]])

(def web-apps
  (util/arrange "Web Apps"
                [web-app 400 0]))

(def presentation
  [:g {:data-title ""}
   [:image {:href "images/rocket.svg"}]])

(def presentations
  (util/arrange "Slides"
                [presentation 400 0]))

(def slides
  (util/arrange "For"
                [documentation 400 0]
                [icons 400 1200]
                [web-apps 400 1500]
                [presentations 400 1900]))
