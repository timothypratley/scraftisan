(ns scraftisan.intro
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def intro
  [:g {:data-title ""}
   (marcup/mo "* A little knowledge goes a long way
* Diagrams are valuable
* SVG is awesome
* Fast feedback")])

(util/save-svg "intro.svg" intro)

(def slides
  (util/arrange [[intro 0 0]]))
