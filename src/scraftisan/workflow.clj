(ns scraftisan.workflow
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def tools
  [:g {:data-title ""}
   (marcup/mo "* Text editor
* Inkscape
* Browser
* REPL: Clay, Portal

Browser")])

(def making-use-of-svg
  [:g {:data-title "making use of svg"}
   (marcup/mo "## Making use of existing SVG
* [fontawesome.com](https://fontawesome.com/search?q=code&o=r&m=free&f=classic)
* [svgrepo.com](https://www.svgrepo.com/vectors/elephant/)
* `<image href=\"...\">`
* Cursive and Calva
* SVG to hiccup [html2hiccup](http://html2hiccup.buttercloud.com/)")])

(def slides
  (util/arrange "Tools"
                [tools 400 0]
                [making-use-of-svg 800 0]))
