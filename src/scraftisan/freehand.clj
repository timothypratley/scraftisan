(ns scraftisan.freehand
  (:require [scraftisan.util :as util]))

(def example
  [:g {:data-title ""}])

(def slides
  (util/arrange [[example 0 0]]))
