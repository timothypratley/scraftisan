(ns scraftisan.html-in-svg
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

;; TODO: is foreignObject a real thing or can you just set the xmlns?
(defn fo [props & body]
  [:foreignObject {:width  "400"
                   :height "200"
                   :style  {:overflow "visible"}}
   (into [:div (util/deep-merge {:xmlns "http://www.w3.org/1999/xhtml"}
                                props)]
         body)])

(def fooo
  [:g {:data-title ""}
   (marcup/mo
    "
```
[:foreignObject {:width 100}
 {:style {:overflow \"visible\"}}
 [:div {:xmlns \"http://www.w3.org/1999/xhtml\"}
  [:div [:h2 \"Hello world\"]
        [:button \"Click me!\"]]]]
```")])

(def foreign-objects
  [:g {:data-title ""}
   (fo {} [:div [:h2 "Hello world"]
           [:button "Click me!"]])])

(def slides
  (util/arrange "HTML in SVG"
                [fooo 400 0]
                [foreign-objects 800 0]))
