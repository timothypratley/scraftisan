(ns scraftisan.svg
  (:require [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind]
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

(defn svg [& body]
  (kind/hiccup
    (into [:svg {:height     "100%"
                 :width      "100%"
                 :viewBox    [0 0 1000 1000]
                 :xmlns      "http://www.w3.org/2000/svg"
                 :style      {:background (color/palette 12)}}]
          body)))

(def slides
  [:g {:data-title "SVG concepts"}
   what-is-svg
   what-is-hiccup])

(defn save [f x]
  (spit f (hiccup2/html x)))
