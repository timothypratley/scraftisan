(ns scraftisan.layout
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def layouts
  [:g {:data-title ""}
   (marcup/mo "Layouts

* Manual
* Automatic
* Mixed")])

(def automatic-layouts
  [:g {:data-title ""}
   (marcup/mo "Should be easy right?

Unsolved, but some interesting takes:

* trees
* gravity/charge simulations
* constraint solvers")])

(def libraries
  [:g {:data-title ""}
   (marcup/mo "Libraries

* Eclipse Layout Kernel
* Webcola")])

(def graphs
  [:g {:data-title ""}
   (marcup/mo "Graph

> A set of things and a set of relations between them")])

(def slides
  (util/arrange "Layouts"
                [layouts 400 0]
                [automatic-layouts 800 0]
                [libraries 1200 0]
                [graphs 1600 0]))
