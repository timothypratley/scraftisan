(ns scraftisan.animation
  (:require [scraftisan.util :as util]))

(def spider
  [:g {}
   [:p "I'm a spider!"]])

(def slides
  (util/arrange [spider 0 0]))
