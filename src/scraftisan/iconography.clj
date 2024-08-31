(ns scraftisan.iconography
  (:require [scraftisan.color :as color]
            [scraftisan.svg :as svg]))

(def scicloj-icons
  [:g {:data-title ""}
   [:circle {:r 10}]])

(def favicon
  [:g {:data-title "favicon"}
   [:circle {:r 128 :fill (color/palette 1)}]])

(def hummi-icon
  [:g {:data-title ""}
   [:circle {:r 128 :fill (color/palette 1)}]])

(svg/save "favicon.svg" (svg/svg  favicon))

(def slides
  [:g {:data-title "iconography"}
   scicloj-icons
   favicon
   hummi-icon])
