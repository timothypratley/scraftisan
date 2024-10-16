(ns scraftisan.intro
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def intro
  [:g {:data-title ""}
   (marcup/mo "* A little knowledge goes a long way
* Diagrams are valuable
* SVG is awesome
* Fast feedback")])

(def slides
  (util/arrange "Introduction"
                [intro 0 0]))
