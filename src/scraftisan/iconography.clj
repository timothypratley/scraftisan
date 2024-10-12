(ns scraftisan.iconography
  (:require [scraftisan.color :as color]
            [scraftisan.util :as util]))

(def scicloj-icons
  [:g {:data-title ""}
   [:circle {:r 10}]])

(def favicon
  [:g {:data-title "favicon"}
   [:circle {:r 128 :fill (color/palette 1)}]])

(def hummi-icon
  [:g {:data-title ""}
   [:circle {:r 128 :fill (color/palette 1)}]])

;;(util/save "favicon.svg" (svg/svg favicon))

(def slides
  (util/arrange [scicloj-icons 0 0]
                [favicon 500 500]
                [hummi-icon 500 800]))
