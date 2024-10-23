(ns scraftisan.why
  (:require [scraftisan.aliens :as aliens]
            [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def what
  [:g {:data-title ""}
   (marcup/md "
Scalable: able to be changed in size

Vector: the relation of two positions

Graphics: Greek graphikos for ‘writing, drawing’")])

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

(def oauth2
  [:g {:data-title ""}
   [:image {:href "images/oauth2.png"
            :width 200}]])

(def slides
  (util/arrange "Why SVG"
                [aliens/slug 0 200]
                [what 400 0]
                [why 800 0]
                [sweet 400 500]
                [oauth2 1400 400]))
