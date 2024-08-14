(ns scraftisan.scratch
  (:require [clojure.string :as str]
            [hiccup2.core :as hiccup2]
            [scraftisan.color :as color]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.svg-concepts :as svg]
            [scraftisan.marcup :as marcup]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :as response]))

(defn gstalt-proximity []
  [:g {:stroke (color/palette 11)}
   #_[:rect {:fill   (palette 10)
             :x      4
             :y      4
             :rx     4
             :width  120
             :height 120}]
   [:g {:fill (color/palette 1)}
    [:circle {:cx -64
              :cy -64
              :r  16}]
    [:circle {:cx 32
              :cy 32
              :r  16}]
    [:circle {:cx 96
              :cy 32
              :r  16}]
    [:circle {:cx 96
              :cy 96
              :r  16}]]])

(svg/svg (gstalt-proximity))

(def hummi-path
  ['M 19 85
   ;; under-tail
   'c 0 0 -1 1 1 0 0 0 8 -5 11 -7.5 0 0 5 -5 10 -5
   ;; body
   10 0 30 -15 30 -35
   ;; chin
   0 0 0 -10 4 -10
   ;; beak
   0 0 10 -2.5 24 -2 0 0 -10 -0.5 -20 -0.5
   ;; head
   -5 0 -5 -1 -10 -3.5 -15 -5 -12 18 -18 18
   ;; over-wing
   -5 0 -8 -8 -50 -13
   ;; under-wing
   30 23 45 25 45 25
   ;; over-tail
   0 0 -6 5 -12 15 0 0 -7 10 -15 18.5])

#_(svg/svg [:path {:d    (str/join " " hummi-path)
                   :fill (palette 1)}])

(defn rand-hummi []
  (let [scale (+ (rand 2) 0.1)
        flip (zero? (rand-int 2))]
    [:g {:transform (str "translate(" (- (rand-int 128) 96) "," (- (rand-int 128) 96) ") scale(" (if flip (- scale) scale) "," scale ")")}
     [:path {:fill (color/palette (inc (rand-int (dec (count color/palette)))))
             :d    (str/join " " hummi-path)}]]))

(defn gstalt-similarity []
  (into [:g]
        (repeatedly 20 rand-hummi)))

(svg/svg (gstalt-similarity))

(defn gstalt-continuity []
  [:path {:d                (str/join " " hummi-path)
          :fill             "none"
          :stroke           (color/palette 1)
          :stroke-width     5
          :stroke-dasharray [5]}])

(svg/svg (gstalt-continuity))

(defn gstalt-closure []
  [:path {:d            (str/join " " (take 70 hummi-path))
          :fill         "none"
          :stroke       (color/palette 1)
          :stroke-width 5}])

(svg/svg (gstalt-closure))

(defn gstalt-symmetry []
  (into [:g]
        (for [x [-1 1]
              y [-1 1]]
          [:path {:transform (str "scale(" x "," y ")")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 3)}])))

(svg/svg (gstalt-symmetry))

(defn gstalt-figure-ground []
  [:path {:transform (str "scale(5,5) translate(" -48 "," -48 ")")
          :d         (str/join " " hummi-path)
          :fill      (color/palette 2)}])

(svg/svg (gstalt-figure-ground))

(defn gstalt-common-fate []
  (into [:g]
        (for [[x y] [[-96 -64] [-32 0] [16 -96] [-64 -32] [0 16]]]
          [:path {:transform (str "translate(" x "," y ") scale(0.5,0.5)")
                  :d         (str/join " " hummi-path)
                  :fill      (color/palette 1)}])))

(svg/svg (gstalt-common-fate))


;; TODO: we need to set up the slide viewboxes
;; TODO: can we make an interactive way of positioning slides and path points?
;; TODO: can we have animations within slides?

(def slides
  [fo/foreign-objects
   marcup/markdown-example
   marcup/making-use-of-svg
   gstalt-figure-ground
   gstalt-symmetry
   gstalt-similarity
   gstalt-proximity
   gstalt-closure
   gstalt-common-fate
   gstalt-continuity])

(defn path [t [x y & more]]
  (str "M" x " " y " " t (str/join " " more)))

(def slide-path
  (apply concat (for [x [-1 0 1 2]
                      y [-1 0 1 2]]
                  [x y])))

(svg/svg [:path {:stroke (color/palette 11)
                 :fill   "none"
                 :d      (path \L (map #(* % 10) slide-path))}])

(defn to [x y]
  (str "translate(" x "," y ")"))

;; TODO: calculate bounds
(def all-slides
  (let [z 50
        s "scale(0.1,0.1)"
        points (partition-all 2 slide-path)]
    (into [:g]
          (for [[[x y] f i] (map vector points slides (range))]
            [:g {:id (format "slide%03d" i)}
             [:g {:transform (str (to (* x z) (* y z)) " " s)}
              (f)]]))))

(svg/svg all-slides)

(spit "scraftisan.svg" (hiccup2/html (svg/svg all-slides)))

(defn tractionize [[g & groups]]
  (assert (= g :g))
  (list
    [:script {:xmlns:xlink "http://www.w3.org/1999/xlink"
              :xlink:href  "traction.js"
              :type        "text/ecmascript"}]
    [:steps {:xmlns "http://chouser.n01se.net/traction/config"}
     [:init
      [:set {:duration "1000"}]]
     (for [i (range (count groups))]
       [:step {:view (format "slide%03d" i)}])]
    groups))

(defn handler [request]
  (case (:uri request)
    "/" (-> (response/response (str (hiccup2/html (svg/svg (tractionize all-slides)))))
            (response/content-type "image/svg+xml"))
    "/traction.js" (response/resource-response "traction.js")
    (response/not-found "Not Found")))

(defn start-server [port]
  (jetty/run-jetty #'handler {:port port :join? false}))

(comment

  (def s (start-server 8045))

  :-)
