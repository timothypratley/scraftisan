(ns scraftisan.layout
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def layouts
  (marcup/mo "Layouts

* Manual
* Automatic
* Mixed"))

(def automatic-layouts
  (marcup/mo "Should be easy right?

Unsolved, but some interesting takes:

* trees
* gravity/charge simulations
* constraint solvers
"

             ))

(def libraries
  (marcup/mo "Libraries

* Eclipse Layout Kernel
* Webcola"))

(def slides
  (util/arrange "Layouts"
                [layouts 0 0]
                [automatic-layouts 400 0]
                [libraries 800 0]))
