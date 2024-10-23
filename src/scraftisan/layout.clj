(ns scraftisan.layout
  (:require [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]
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

> A set of things and a set of relations between them")
   [:g {:fill "none", :stroke-linecap "round", :stroke-linejoin "round", :stroke-width "31",
        :transform "translate(300,150) scale(0.5,0.5)"}
    #_[:circle {:cx "0", :cy "0", :fill "#FFFFFF", :r "128", :stroke "none"}]
    [:g {:id "net"}
     [:g {:stroke "#E0E0E0", :stroke-width "4"}
      [:g
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "-32", :y2 "64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "0", :y2 "64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "-64"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "-32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "0"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "32"}]
       [:line {:x1 "-64", :x2 "0", :y1 "32", :y2 "64"}]]
      [:g
       [:line {:x1 "0", :x2 "64", :y1 "-64", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-64", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-32", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "-32", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "0", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "0", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "32", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "32", :y2 "16"}]
       [:line {:x1 "0", :x2 "64", :y1 "64", :y2 "-16"}]
       [:line {:x1 "0", :x2 "64", :y1 "64", :y2 "16"}]]]
     [:g {:fill "#FFCD52"}
      [:circle {:cx "-64", :cy "-32", :r "14"}]
      [:circle {:cx "-64", :cy "0", :r "14"}]
      [:circle {:cx "-64", :cy "32", :r "14"}]]
     [:g {:fill "#A86F40"}
      [:circle {:cx "0", :cy "-64", :r "14"}]
      [:circle {:cx "0", :cy "-32", :r "14"}]
      [:circle {:cx "0", :cy "0", :r "14"}]
      [:circle {:cx "0", :cy "32", :r "14"}]
      [:circle {:cx "0", :cy "64", :r "14"}]]
     [:g {:fill "#F26767"}
      [:circle {:cx "64", :cy "-16", :r "14"}]
      [:circle {:cx "64", :cy "16", :r "14"}]]]]])

(def graph-icon
  [:g {:data-title ""
       :transform "scale(0.3,0.3)"
       :fill (color/palette 11)}
   [:path {:d "M0 80C0 53.5 21.5 32 48 32l96 0c26.5 0 48 21.5 48 48l0 16 192 0 0-16c0-26.5 21.5-48 48-48l96 0c26.5 0 48 21.5 48 48l0 96c0 26.5-21.5 48-48 48l-96 0c-26.5 0-48-21.5-48-48l0-16-192 0 0 16c0 1.7-.1 3.4-.3 5L272 288l96 0c26.5 0 48 21.5 48 48l0 96c0 26.5-21.5 48-48 48l-96 0c-26.5 0-48-21.5-48-48l0-96c0-1.7 .1-3.4 .3-5L144 224l-96 0c-26.5 0-48-21.5-48-48L0 80z"}]])

(def slides
  (util/arrange "Layout"
                [graph-icon 30 120]
                [layouts 400 0]
                [automatic-layouts 800 0]
                [libraries 1200 0]
                [graphs 1600 0]))
