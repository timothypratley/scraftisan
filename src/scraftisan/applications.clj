(ns scraftisan.applications
  (:require [scraftisan.util :as util]
            [scraftisan.inheritance :as inheritance]
            [hiccup2.core :refer [raw]]))

(def applic
  [:g {:data-title ""}
   [:h2 "Applications"]
   [:li "Web apps"]
   [:li "Images"]
   [:li "Diagrams"]])

(def web-apps
  [:g {:data-title ""}
   [:circle :r 10]])

(def images
  [:g {:data-title ""}
   [:circle :r 10]])

(def plantuml
  [:g {:data-title ""
       :transform "scale(0.3, 0.3)"}
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

(def slides
  (util/arrange "Applications"
                [plantuml 0 100]
                [inheritance/diagram 0 500]
                #_[applic 0 0]
                #_[web-apps 300 0]
                #_[images 300 300]))
