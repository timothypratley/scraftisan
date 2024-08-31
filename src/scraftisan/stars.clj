(ns scraftisan.stars
  (:require [clojure.string :as str]
            [scicloj.kindly.v4.kind :as kind]
            [scraftisan.color :as color]))

(def constellations
  (array-map
    "Ursa Minor" [[0 0 1 "Polaris"]
                  [-3.5 -0.5 0.4]
                  [-7 1.5 0.5]
                  [-10.5 3.5 0.5]
                  [-13 3 0.4]
                  [-14.5 6.5 1]
                  [-11.5 6.5 1]]

    "Ursa Major" [[-18 24 1 "Mizar"]
                  [-15 21 1]
                  [-12 22 1]
                  [-7.5 22 0.5]
                  [-6.5 24.25 1]
                  [-0.75 22.5 1]
                  [-0.75 19.25 1]
                  [8.75 25.5 0.5]
                  [14 26.5 0.5]
                  [13 28 0.4]
                  [-5.25 28.25 0.4]
                  [-1.5 31.5 0.5]
                  [3.75 33.25 0.5]
                  [4.75 31.75 0.4]]

    ;; "Draco" [[]]
    ))

(def night-sky
  (into [:g {:data-title ""
             :transform  "translate(500,250) scale(5,5)"
             :fill       (color/palette 0)}
         (let [len 2.0
               l2 (/ len 2.0)
               w (/ len 10.0)
               -len (- len)
               -l2 (- l2)
               -w (- w)]
           [:g {:id   "north star"
                :fill (color/palette 0)
                #_#_:transform "translate(-30,-30) scale(1,1.2)"}
            [:path {:d (str/join " " ['M 0 -len 'L w 0 0 len -w 0 'Z])}]
            [:path {:d (str/join " " ['M -len 0 'L 0 w len 0 0 -w 'Z])}]
            [:path {:d (str/join " " ['M -l2 -l2 'L -w 0 l2 l2 w 0 'Z])}]
            [:path {:d (str/join " " ['M -l2 l2 'L -w 0 l2 -l2 w 0 'Z])}]])]
        (for [[cname stars] constellations
              [x y luminosity] stars]
          [:circle {:cx x :cy y :r (* luminosity 0.5)}])))

;; TODO: remove
(def night-sky-standalone
  (kind/hiccup
    [:svg {:height  "100%"
           :width   "100%"
           :viewBox [-127 -127 256 256]
           :xmlns   "http://www.w3.org/2000/svg"}
     [:rect {:fill   (color/palette 12)
             :stroke (color/palette 0)
             :x      -127
             :y      -127
             :width  256
             :height 256
             :rx     4}]
     night-sky]))

(def thematic
  [:g {:data-title ""}
   [:p
    "* a little bit of knowledge can take you a long way
    * to the stars!"]])

(def slides
  [:g {:data-title    ""
       :data-absolute true}
   thematic
   night-sky])
