(ns scraftisan.why
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def why
  [:g {:data-title ""}
   (marcup/md "* Data
* Scalable
* Web Standard (tools!)
* Extensible
* Animatable
* Language spectrum sweet spot")])

(def sweet
  [:g {:data-title ""}
   [:image {:href "images/spectrum.svg"}]])

(def slides
  (util/arrange "Why SVG"
                [why 400 0]
                [sweet 800 0]))
