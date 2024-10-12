(ns scraftisan.html-in-svg
  (:require [scraftisan.util :as util]))

;; TODO: is foreignObject a real thing or can you just set the xmlns?
(defn fo [props & body]
  [:foreignObject {:style {:overflow "visible"
                           :width    1
                           :height   1}}
   (into [:div (util/deep-merge {:xmlns "http://www.w3.org/1999/xhtml"}
                                props)]
         body)])

(def foreign-objects
  (fo {:style {:width "100%"}}
      [:div "Hello world"
       [:button "Click me!"]]))

(def slides
  (util/arrange [foreign-objects 0 0]))
