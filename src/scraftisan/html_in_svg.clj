(ns scraftisan.html-in-svg
  (:require [scraftisan.util :as util]))

;; TODO: is foreignObject a real thing or can you just set the xmlns?
(defn fo [props & body]
  [:foreignObject {:width      "400"
                   :height     "200"
                   :style  {:overflow "visible"}}
   (into [:div (util/deep-merge {:xmlns "http://www.w3.org/1999/xhtml"}
                                props)]
         body)])

(def foreign-objects
  [:g {:data-title ""}
   (fo {} [:div "Hello world"
           [:button "Click me!"]])])

(def slides
  (util/arrange "HTML in SVG"
                [foreign-objects 400 0]))
