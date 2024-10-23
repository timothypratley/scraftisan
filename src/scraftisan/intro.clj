(ns scraftisan.intro
  (:require [scraftisan.util :as util]))

(def title
  [:g {:transform "scale(100,100)"}
   (util/fo {}
            [:p "Crafting Artisanal Vector Graphics"])])

(def bottom-right
  [:g [:circle {:r 0.1}]])

(def slides
  (util/arrange "Introduction"
                [title -80000 -60000]
                [bottom-right 80000 60000]))
