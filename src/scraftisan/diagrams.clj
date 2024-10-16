(ns scraftisan.diagrams
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

;; All good diagramming principles flow from the legend
;; - good choices for communication

;; Yes napkins and whiteboards,
;; but actually using or creating a logical framework helps.

(def legends
  (marcup/mo "Ledgends never die
"))

(def slides
  (util/arrange "Diagrams"
                [legends 0 0]))
