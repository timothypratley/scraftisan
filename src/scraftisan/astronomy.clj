(ns scraftisan.astronomy
  (:require [scraftisan.util :as util]))

(def ptolemy
  [:g {:data-title ""}
   [:image {:height 100
            :href  "astronomy/ptolemy.gif"}]])

(def epicycles
  [:g {:data-title ""}
   [:image {:height 100
            :href "astronomy/epicycles.png"}]])

(def epicycles2
  [:g {:data-title ""}
   [:image {:height 100
            :href "astronomy/epicycles2.png"}]])

(def copernicus
  [:g {:data-title ""}
   [:image {:height 100
            :href  "astronomy/copernicus-diagram.jpeg"}]])

(def slides
  (util/arrange "Astronomy"
                [ptolemy 300 0]
                [epicycles 450 0]
                [epicycles2 600 0]
                [copernicus 750 0]))
