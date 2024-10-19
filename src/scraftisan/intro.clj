(ns scraftisan.intro
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def title
  [:g {:transform "scale(100,100)"}
   (util/fo {}
            [:p "Crafting Artisanal Vector Graphics"])])

(def bottom-right
  [:g (util/fo {} [:p "."])])

(def intro
  [:g {:data-title ""}
   (marcup/md "* A little knowledge goes a long way
* Diagrams are valuable
* SVG is awesome
* Fast feedback")])

(def slides
  (util/arrange "Introduction"
                [title -80000 -60000]
                [intro 400 0]
                [bottom-right 80000 60000]))
