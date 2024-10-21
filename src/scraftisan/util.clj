(ns scraftisan.util
  (:require [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind])
  (:import (java.util Random)))

(def ^:dynamic *random*
  (Random. 314159265359))

(defn srand
  ([] (.nextDouble *random*))
  ([n] (* n (srand))))

(defn srand-int [n]
  (.nextInt *random* n))

(defn srand-nth [coll]
  (nth coll (srand-int (count coll))))

(defmacro with-seed [& body]
  `(binding [*random* (Random. 314159265359)]
     ~@body))

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

(defn fo [props & body]
  [:foreignObject {:style {:color     "white"
                           :font-size "50px"
                           :overflow  "visible"
                           :width     "250"
                           :height    "40"}}
   (into [:div (deep-merge {:xmlns "http://www.w3.org/1999/xhtml"}
                           props)]
         body)])

(defn arrange [title & slides]
  (let [col (srand-nth ["red"
                       "brown"
                       "purple"
                       "pink"
                       "orange"
                       "gold"
                       "blue"
                       "darkblue"
                       "teal"
                       "green"
                       "darkgreen"])]
    (conj (into [:g {:data-title title
                     :style      {:outline        (str "solid 10px " col)
                                  :outline-offset "50px"}}]
                (for [[slide x y] slides]
                  [:g {:transform (str "translate(" x "," y ")")}
                   slide]))
          (fo {:style {:background col}}
              title))))

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

(defn alien [s]
  [:g {:data-title ""
       :stroke "lightgreen"}
   [:image {:href  (str "aliens/" s ".svg")
            :width 100}]])
