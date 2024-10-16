(ns scraftisan.applications
  (:require [scraftisan.util :as util]))

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
   [:image {:href "images/plantuml.svg" :width 313 :height 572}]])

(def slides
  (util/arrange "Applications"
                [applic 0 0]
                [web-apps 300 0]
                [images 300 300]
                [diagrams 0 300]))
