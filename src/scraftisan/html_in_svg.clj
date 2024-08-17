(ns scraftisan.html-in-svg)

;; TODO: we don't need this, if we want it we could depend on medley or similar
(defn merge-deep
  ([m1 m2]
   (if (and (or (nil? m1) (map? m1))
            (or (nil? m2) (map? m2)))
     (merge-with merge-deep m1 m2)
     m2))
  ([m1 m2 & more]
   (reduce (fn [acc m]
             (merge-deep acc m))
           (merge-deep m1 m2)
           more)))

(defn fo [props & body]
  [:foreignObject (merge-deep {:style {:overflow "visible"
                                       :width    1
                                       :height   1}}
                              props)
   (into
     [:div {:xmlns "http://www.w3.org/1999/xhtml"}]
     body)])

(def foreign-objects
  (fo {:style {:width "100%"}}
      [:div "Hello world"
       [:button "Click me!"]]))

(def slides
  [:g {:data-title "html in SVG"}
   foreign-objects])
