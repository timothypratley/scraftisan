(ns scraftisan.util
  (:require [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind]))

(defn arrange [slides]
  (->> (for [[slide x y] slides]
         [:g {:transform (str "translate(" x "," y ")")} slide])
       (into [:g {:data-title ""}])))

(defn deep-merge
  "Recursively merges maps only."
  [& xs]
  (->> xs
       (remove nil?)
       (reduce (fn m [a b]
                 (if (and (map? a) (map? b))
                   (merge-with m a b)
                   b))
               {})))

(defn svg [props & body]
  (kind/hiccup
    (into [:svg (deep-merge {:height       "100%"
                             :width        "100%"
                             :viewBox      [0 0 1000 1000]
                             :xmlns        "http://www.w3.org/2000/svg"
                             "xmlns:xlink" "http://www.w3.org/1999/xlink"}
                            props)]
          body)))

(defn save [f x]
  (spit f (hiccup2/html x)))

(defn save-svg [f x]
  (save f (svg {} x)))
