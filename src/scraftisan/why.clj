(ns scraftisan.why
  (:require [scraftisan.aliens :as aliens]
            [scraftisan.marcup :as marcup]
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

;; TODO: Debuggable! (maybe just open the console during the presentation)

(def slides
  (util/arrange "Why SVG"
                [aliens/slug 0 200]
                [why 400 0]
                [sweet 800 0]))
