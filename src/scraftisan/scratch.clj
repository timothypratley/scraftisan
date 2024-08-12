(ns scraftisan.scratch
  (:require [clojure.string :as str]
            [hiccup2.core :as hiccup2]
            [scicloj.kindly.v4.kind :as kind]
            [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as mdt]))

(def palette
  ["#FCFFE0"
   "#D0F040"
   "#E6E6FA"
   "#D0F7FF"
   "#FCECC5"
   "#FCE2F7"
   "#E0FFD0"
   "#F0D0E0"
   "#40D0A0"
   "#FF8080"
   "#F0F0C8"
   "#AFA050"])

(defn svg [& body]
  (kind/hiccup
    (into [:svg {:height  256
                 :width   256
                 :viewBox [-127 -127 256 256]
                 :xmlns   "http://www.w3.org/2000/svg"}
           [:rect {:fill   (palette 0)
                   :stroke (palette 11)
                   :x      -127
                   :y      -127
                   :width  256
                   :height 256
                   :rx     4}]]
          body)))

(defn palette-view []
  (let [w 32 h 32]
    (->> (partition-all 3 palette)
         (map-indexed (fn [y row]
                        (->> (map-indexed (fn [x color]
                                            [:path {:transform (str "translate(" (* (- x 1) w 2) " " (* (- y 1) h 2) ")")
                                                    :fill      color
                                                    :d         (str/join " " ['M (- w) (- h)
                                                                              'L w (- h) w h (- w) h
                                                                              'Z])}])
                                          row)
                             (into [:g]))))
         (into [:g]))))

(svg (palette-view))

(defn gstalt-proximity []
  [:g {:stroke (palette 11)}
   #_[:rect {:fill   (palette 10)
             :x      4
             :y      4
             :rx     4
             :width  120
             :height 120}]
   [:g {:fill (palette 1)}
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

(svg (gstalt-proximity))

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

#_(svg [:path {:d    (str/join " " hummi-path)
               :fill (palette 1)}])

(defn rand-hummi []
  (let [scale (+ (rand 2) 0.1)
        flip (zero? (rand-int 2))]
    [:g {:transform (str "translate(" (- (rand-int 128) 96) "," (- (rand-int 128) 96) ") scale(" (if flip (- scale) scale) "," scale ")")}
     [:path {:fill (palette (inc (rand-int (dec (count palette)))))
             :d    (str/join " " hummi-path)}]]))

(defn gstalt-similarity []
  (into [:g]
        (repeatedly 20 rand-hummi)))

(svg (gstalt-similarity))

(defn gstalt-continuity []
  [:path {:d                (str/join " " hummi-path)
          :fill             "none"
          :stroke           (palette 1)
          :stroke-width     5
          :stroke-dasharray [5]}])

(svg (gstalt-continuity))

(defn gstalt-closure []
  [:path {:d            (str/join " " (take 70 hummi-path))
          :fill         "none"
          :stroke       (palette 1)
          :stroke-width 5}])

(svg (gstalt-closure))

(defn gstalt-symmetry []
  (into [:g]
        (for [x [-1 1]
              y [-1 1]]
          [:path {:transform (str "scale(" x "," y ")")
                  :d         (str/join " " hummi-path)
                  :fill      (palette 3)}])))

(svg (gstalt-symmetry))

(defn gstalt-figure-ground []
  [:path {:transform (str "scale(5,5) translate(" -48 "," -48 ")")
          :d         (str/join " " hummi-path)
          :fill      (palette 2)}])

(svg (gstalt-figure-ground))

(defn gstalt-common-fate []
  (into [:g]
        (for [[x y] [[-96 -64] [-32 0] [16 -96] [-64 -32] [0 16]]]
          [:path {:transform (str "translate(" x "," y ") scale(0.5,0.5)")
                  :d         (str/join " " hummi-path)
                  :fill      (palette 1)}])))

(svg (gstalt-common-fate))

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

(defn foreign-objects []
  (fo {:style {:width "100%"}}
      [:div "Hello world"
       [:button "Click me!"]]))

(svg (foreign-objects))

(defn marcup
  "Hiccup doesn't support fragments [:<> ...] yet, but does support seq fragments.
  We render fragments as seqs, so they can be converted correctly by hiccup."
  [s]
  (->> (md/parse s)
       (mdt/->hiccup (assoc mdt/default-hiccup-renderers
                       :plain (fn [ctx {:keys [text content]}]
                                (or text (map #(mdt/->hiccup ctx %) content)))))))

(defn markdown-example []
  (fo {:style {:width "100%"}}
      (marcup "## This is **markdown**
* Because we like markdown
* It's nice")))

(svg (markdown-example))

(defn making-use-of-svg []
  (fo {:style {:width "100%"}}
      (marcup "## Making use of existing SVG
* Converting SVG (XML) to hiccup
* Cursive offers to do it when you copy paste
* Does emacs?
* Font awesome SVGs are useful (https://fontawesome.com/search?q=code&o=r&m=free&f=classic)
* Copy the SVG code, and paste it into hiccup")))

;; TODO: we need to set up the slide viewboxes
;; TODO: can we make an interactive way of positioning slides and path points?
;; TODO: can we have animations within slides?

(def slides
  [foreign-objects
   markdown-example
   gstalt-figure-ground
   gstalt-symmetry
   gstalt-similarity
   gstalt-proximity
   gstalt-closure
   gstalt-common-fate
   gstalt-continuity
   making-use-of-svg])

(defn path [t [x y & more]]
  (str "M" x " " y " " t (str/join " " more)))

(def slide-path
  [-2 -2
   -2 -1
   -1 -2
   -1 -1
   0 0
   0 1
   1 1
   1 2
   0 2
   0 3
   1 3
   2 2])

(svg [:path {:stroke (palette 11)
             :fill   "none"
             :d      (path \L (map #(* % 10) slide-path))}])

(defn zip [v1 v2]
  (map vector v1 v2))

(defn tr [x y]
  (str "translate(" x "," y ")"))

;; TODO: calculate bounds
(def all-slides
  (let [z 300
        s "scale(0.2,0.2)"
        points (partition-all 2 slide-path)]
    (into [:g]
          (for [[[x y] f] (zip points slides)]
            [:g {:transform (str s " " (tr (* x z) (* y z)))}
             (f)]))))

(svg all-slides)

(spit "scraftisan.svg" (hiccup2/html (svg all-slides)))
