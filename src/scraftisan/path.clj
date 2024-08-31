(ns scraftisan.path
  (:require [clojure.string :as str]
            [clojure.math :as math]
            [scraftisan.color :as color]))

(def paths-are-cool
  [:g {:data-title ""}
   [:path {:d (str/join " " ['M 0 0 'L 10 10 20 20])}]
   [:p "Shapes, lines, curves, quartic, cubic"]
   [:p "strokes, fills, closure"]
   [:p "masks"]])

(defn path+points [d]
  (into
    [:g [:path {:d (str/join " " d)}]]
    (map-indexed (fn [idx [x y]]
                   [:g
                    [:circle {:cx           x
                              :cy           y
                              :r            3
                              :stroke-width 3
                              :stroke       (color/palette 9)}]
                    [:text {:x    (+ 5 x)
                            :y    y
                            :fill (color/palette 9)}
                     (str "p" idx)]])
                 (partition-all 2 (filter number? d)))))

(def landscape
  [:g {:data-title ""
       :fill       (color/palette 11)
       :opacity 0.75}
   ;; straight line
   [:path {:d (str/join " " ['M 0 500 'L 1000 500])}]
   ;; chain points
   [:path {:d (str/join " " ['M 0 500 'L 100 480 200 500 300 460 400 500])}]
   ;; Quadratic curves

   ;;[:path {:d (str/join " " ['M 400 500 'Q 500 500 600 450 ,, 600 450 700 450 800 500 ,, 800 500 900 400 1000 500])}]

   ;; bell curve
   (path+points ['M 400 500 'Q 500 500, 600 450,, 700 400, 800 450,, 900 500 1000 500 'Z])

   ;; touching every point:
   ;; supply an extra control point, then imply the rest.
   [:g {:opacity 0.5
        :fill "green"}
    (path+points ['M 400 500 'M 500 500, 'Q 550, 500 600 450,, 'T 700 400, 800 450,, 900 500 1000 500 'Z])]

   ;; approximate a circle with quadratics
   #_
   (let [a (- (math/sqrt 2) 0.5)                            ; 0.914
         r 50
         -r (- r)
         r' (* a r)
         -r' (- r')]
     [:g {:transform    "translate(500,750) scale(5)"
          :stroke-width 2}
      (path+points ['M 0 -r 'Q r' -r', r 0,, r' r', 0 r,, -r' r', -r 0,, -r' -r', 0 -r 'Z])])

   ;; approximate a circle with cubics
   #_
   (let [k (* (/ 4 3) (- (math/sqrt 2) 1))                  ; 0.552
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

(def earth
  [:g {:data-title ""}
   [:circle {:cx   500
             :cy   5470
             :r    5000
             :fill (color/palette 1)}]])

(def slides
  [:g {:data-title ""}
   paths-are-cool
   earth
   landscape])
