(ns scraftisan.legends
  (:require [scraftisan.util :as util]))

;; All good diagramming principles flow from the legend
;; - good choices for communication

;; Yes napkins and whiteboards,
;; but actually using or creating a logical framework helps.

(def legends
  [:g {:data-title ""}
   [:p "hello world"]])

(def slides
  (util/arrange [[legends 0 0]]))
