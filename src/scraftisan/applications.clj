(ns scraftisan.applications
  (:require [scraftisan.util :as util]
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

(def diagrams
  [:g {:data-title ""
       :transform "scale(0.3, 0.3)"}
   [:foreignObject {:width 500 :height 400 :transform "translate(-500, 100)"}
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
   [:image {:href "images/plantuml.svg" :width 313 :height 572}]])

(def slides
  (util/arrange "Applications"
                [applic 0 0]
                [web-apps 300 0]
                [images 300 300]
                [diagrams 0 300]))
