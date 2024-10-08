(ns scraftisan.workflow
  (:require [scraftisan.util :as util]))

(def tools
  [:g {:data-title ""}])

(def slides
  (util/arrange [[tools 0 0]]))
