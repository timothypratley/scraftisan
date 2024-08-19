(ns scraftisan.svg-concepts
  (:require [clojure.string :as str]
            [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind]
    #_[scraftisan.marcup :as marcup]
            [scraftisan.color :as color]))


(def what-is-svg
  [:g {:data-title "what is SVG"}
   [:p "It's XML!"]
   [:code [:pre "<svg xmlns=\"http://www.w3.org/2000/svg\">
…
</svg>"]]
   [:circle {:r 20 :fill (color/palette 1)}]]

  )

(def what-is-hiccup
  [:g {:data-title ""}
   [:p "We love Hiccup"]
   [:code [:pre "Xml namespace is a required
[:svg {:xmlns \"http://www.w3.org/2000/svg\"} …]
"]]])

(def paths-are-cool
  [:g {:data-title ""}
   [:path {:d (str/join " " ['M 0 0 'L 10 10 20 20])}]
   [:p "Shapes, lines, curves, quartic, cubic"]
   [:p "strokes, fills, closure"]
   [:p "masks"]])

(defn svg [& body]
  (kind/hiccup
    (into [:svg {:height  "100%"
                 :width   "100%"
                 :viewBox [-127 -127 256 256]
                 :xmlns   "http://www.w3.org/2000/svg"}
           [:rect {:fill   (color/palette 0)
                   :stroke (color/palette 11)
                   :x      -127
                   :y      -127
                   :width  256
                   :height 256
                   :rx     4}]]
          body)))

(def slides
  [:g {:data-title "SVG concepts"}
   what-is-svg
   what-is-hiccup
   paths-are-cool])

(defn save [f x]
  (spit f (hiccup2/html x)))
