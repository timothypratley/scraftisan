(ns scraftisan.workflow
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def tools
  [:g {:data-title ""}
   (marcup/mo "Inkscape

Clay

Browser")])

(def slides
  (util/arrange "Tools"
                [tools 400 0]))
