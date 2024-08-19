(ns scraftisan.applications
  (:require [scraftisan.marcup :as marcup]))

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
  [:g {:data-title "applications"}
   applic
   web-apps
   images
   diagrams])
