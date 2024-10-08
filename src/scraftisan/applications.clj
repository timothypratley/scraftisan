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
  [:g {:data-title ""}
   [:circle :r 10]])

(def slides
  (util/arrange [[applic 0 0]
                 [web-apps 300 0]
                 [images 300 300]
                 [diagrams 0 300]]))
