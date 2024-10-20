(ns scraftisan.paths
  (:require [clojure.string :as str]
            [clojure.math :as math]
            [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def paths-are-cool
  [:g {:data-title ""}
   (marcup/md "Paths

```
[:path {:d \"M 0 0 L 10 10 20 20\"}]
```
")
   [:path {:d (str/join " " ['M 0 0 'L 10 10 20 20])}]])

;; TODO: mention
[
 [:p "Shapes, lines, curves, quartic, cubic"]
 [:p "strokes, fills, closure"]
 [:p "masks"]]


(defn path+points [d]
  (into
    [:g [:path {:d (str/join " " d)}]]
    (map-indexed (fn [idx [x y]]
                   [:g
                    [:circle {:cx           x
                              :cy           y
                              :r            3
                              :stroke-width 1
                              :fill         'none
                              :stroke       (color/palette 9)}]
                    [:text {:x    (+ 5 x)
                            :y    y
                            :fill (color/palette 9)}
                     (str "p" idx)]])
                 (partition-all 2 (filter number? d)))))

(def landscape
  [:g {:data-title ""
       :fill       (color/palette 11)
       :opacity    0.75}
   ;; straight line
   [:path {:d (str/join " " ['M 0 500 'L 1000 500])}]
   ;; chain points
   #_[:path {:d (str/join " " ['M 0 500 'L 100 480 200 500 300 460 400 500])}]

   #_[:path {:transform "translate(0,500) scale(2,2)"
             :d         (str/join " " ['M 0 0 'L 100 -20, 200 0 300 -40, 400 0])}]

   ;; choosing control points exactly between each of the end point makes exactly the same jagged line
   #_[:path {:transform "translate(0,500) scale(2,2)"
             :d         (str/join " " ['M 0 0 'Q 50 -10, 100 -20,, 150 -10, 200 0,, 250 -20, 300 -40,, 350 -20, 400 0])}]

   ;; by offsetting the control points, we can get curves with a sharp corner at the endpoints
   #_[:path {:transform "translate(0,500) scale(2,2)"
             :d         (str/join " " ['M 0 0 'Q 50 -20, 100 -20,, 150 0, 200 0,, 250 -40, 300 -40,, 350 0, 400 0])}]

   ;; Maybe T with extra points is easiest?
   #_[:path {:transform "translate(0,500) scale(2,2)"
             :d         (str/join " " ['M 0 0 'T 30 -15,, 100 -20,, 150 -15,, 200 0,, 300 -40,, 400 0])}]

   ;; Nope, it's a mess
   #_[:g {:transform "translate(0,500) scale(2,2)"}
      (path+points ['M 0 0 'Q -50 15, 0 0 'T 50 -15,, 100 -20,, 150 -15,, 200 0,, 300 -40,, 400 0])]

   ;; Kill the sharp corners with control points that form a line with their endpoint
   (let [p (fn [x y width]                                  ;; two control points in a horizontal line with the endpoint in the middle
             [(- x width) y
              x y
              (+ x width) y])]
     [:g {:transform "translate(0,500) scale(2,2)"}
      (path+points (flatten ['M 0 0 'C 40 0
                             (p 100 -20, 40)
                             (p 200 0, 50)
                             (p 300 -40, 40)
                             (p 400 0, 50)]))])

   [:path {:transform "translate(0,500) scale(2,2)"
           :stroke    "#5555ff"
           :fill      "none"
           :d         (str/join " " ['M 0 0 'L 100 -20, 200 0 300 -40, 400 0])}]
   ;; Quadratic curves

   ;;[:path {:d (str/join " " ['M 400 500 'Q 500 500 600 450 ,, 600 450 700 450 800 500 ,, 800 500 900 400 1000 500])}]

   ;; bell curve
   #_(path+points ['M 400 500 'Q 500 500, 600 450,, 700 400, 800 450,, 900 500 1000 500 'Z])

   ;; touching every point:
   ;; supply an extra control point, then imply the rest.
   #_[:g {:opacity 0.5
          :fill    "green"}
      (path+points ['M 400 500 'M 500 500, 'Q 550, 500 600 450,, 'T 700 400, 800 450,, 900 500 1000 500 'Z])]

   ;; approximate a circle with quadratics
   #_(let [a (- (math/sqrt 2) 0.5)                          ; 0.914
           r 50
           -r (- r)
           r' (* a r)
           -r' (- r')]
       [:g {:transform    "translate(500,750) scale(5)"
            :stroke-width 2}
        (path+points ['M 0 -r 'Q r' -r', r 0,, r' r', 0 r,, -r' r', -r 0,, -r' -r', 0 -r 'Z])])

   ;; approximate a circle with cubics
   #_(let [k (* (/ 4 3) (- (math/sqrt 2) 1))                ; 0.552
           r 50
           -r (- r)
           r' (* k r)
           -r' (- r')]
       [:g {:transform    "translate(500,750) scale(5)"
            :stroke       "red"
            :stroke-width 2}
        (path+points ['M r 0
                      'C r r', r' r, 0 r
                      'C -r' r, -r r', -r 0
                      'C -r -r', -r' -r, 0 -r
                      'C r' -r, r -r', r 0 'Z'])])

   ;; not a circle
   #_(path+points ['M 450 750 'Q 450 800, 500 800,, 550 800, 550 750,, 550 700, 500 700,, 450 700, 450 750 'Z])


   ;; Cubic curves use 2 control points.
   ;;[:path {:d (str/join " " ['M -100 100 'C 10 10 20 20 30 30])}]

   ;; TODO: I don't use these should I use them?
   ;; S curves
   ;;[:path [:d (str/join " " ['M -100 100 'S 10 10 20 20])]]
   ;; T curves
   ;;[:path [:d (str/join " " ['M -100 100 'S 10 10 20 20])]]

   ;; arcs -- I don't use em

   ;; close path with Z
   [:path {:d (str/join " " ['M -100 100 'L 100 100 'Z])}]

   ;; fill

   ;; strokes
   ;; stroke-linecap butt square round
   ;; stroke-linejoin

   ;; paint order

   ])

(def slides
  (util/arrange "Paths"
                [paths-are-cool 400 0]
                [landscape 400 0]))
