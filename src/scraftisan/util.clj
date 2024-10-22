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

(def dark-palette
  ["#4C5331"  ; Olive Green (Complementary to #FCFFE0)
   "#607A30"  ; Medium Olive Green (Complementary to #D0F040)
   "#554D79"  ; Dark Lavender (Complementary to #E6E6FA)
   "#37606A"  ; Deep Aquamarine (Complementary to #D0F7FF)
   "#846847"  ; Warm Sand Brown (Complementary to #FCECC5)
   "#7A476A"  ; Deep Rose (Complementary to #FCE2F7)
   "#48684B"  ; Deep Forest Green (Complementary to #E0FFD0)
   "#7A4F5A"  ; Muted Raspberry (Complementary to #F0D0E0)
   "#2C7A68"  ; Rich Teal (Complementary to #40D0A0)
   "#B35656"  ; Rich Coral (Complementary to #FF8080)
   "#5F6133"  ; Olive Drab (Complementary to #F0F0C8)
   "#8A7740"  ; Golden Brown (Complementary to #AFA050)
   "#2A3147"  ; Navy Slate (Neutral dark, complements brighter shades)
   "#3F4856"  ; Cool Slate Blue (Adds dimension to the palette)
   "#574A71"  ; Dusty Plum (A purple-gray mix for variety)
   "#3B6167"  ; Muted Aqua (Balances warm and cool tones)
   "#586267"  ; Cool Gray (For a slightly neutral option)
   "#75534C"  ; Muted Brick Red (Earthy, grounding tone)
   "#3A5A4A"  ; Forest Green (Natural dark tone)
   "#644B52"  ; Smoky Mauve (Hints of red and purple)
   ])

(defn arrange [title & slides]
  (let [col (srand-nth dark-palette)]
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
