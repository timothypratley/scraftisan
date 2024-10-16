(ns scraftisan.why
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def why
  (marcup/md "* Scalable
* Data
* Programmable
* Sweet spot
* Standard
* Tools"))

(def why1
  (marcup/md "Scalable"))

(def why2
  (marcup/md "Data"))

(def why3
  (marcup/md "Programmable"))

(def why4
  (marcup/md "Sweet spot"))

(def why5
  (marcup/md "Standard"))

(def why6
  (marcup/md "Tools"))

(def slides
  (util/arrange "Why SVG"
                [why 0 0]
                [why1 400 0]
                [why2 800 0]
                [why3 1200 0]
                [why4 400 300]
                [why5 800 300]
                [why6 1200 300]))
