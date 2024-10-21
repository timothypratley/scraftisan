(ns scraftisan.how
  (:require [scraftisan.aliens :as aliens]
            [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]
            [scraftisan.html-in-svg :as fo]
            [scraftisan.util :as util]))

(def file-icon
  [:path {:transform "translate(250) scale(0.1,0.1)"
          :fill      (color/palette 0)
          :d         "M320 464c8.8 0 16-7.2 16-16l0-288-80 0c-17.7 0-32-14.3-32-32l0-80L64 48c-8.8 0-16 7.2-16 16l0 384c0 8.8 7.2 16 16 16l256 0zM0 64C0 28.7 28.7 0 64 0L229.5 0c17 0 33.3 6.7 45.3 18.7l90.5 90.5c12 12 18.7 28.3 18.7 45.3L384 448c0 35.3-28.7 64-64 64L64 512c-35.3 0-64-28.7-64-64L0 64z"}])

(def what-is-svg
  [:g {:data-title "what is SVG"}
   (marcup/md "It's XML!
```
<svg xmlns=\"http://www.w3.org/2000/svg\">
```

The namespace is easy to forget but necessary!

Hiccup:
```
[:svg {:xmlns \"http://www.w3.org/2000/svg\"} …]
```")
   file-icon])

(def what-is-hiccup
  [:g {:data-title ""}
   (marcup/md "
```
[:svg {:xmlns \"http://www.w3.org/2000/svg\"}

 [:circle {:r 20}]]
```")
   [:circle {:r    20
             :cx   200
             :cy   100
             :fill (color/palette 0)}]])

(def snowman
  [:g {:data-title ""}
   (marcup/md "```
 [:circle {:r 20}]
 [:circle {:r 30 :cy 45}]
 [:circle {:r 40 :cy 105}]
```")
   [:g {:fill (color/palette 0) :transform "translate(300, 50)"}
    [:circle {:r 20}]
    [:circle {:r 30 :cy 45}]
    [:circle {:r 40 :cy 105}]]])

(def fill
  [:g {:data-title ""}
   (marcup/md "Fill color")
    [:g {:data-title "" :transform "translate(180, -20) scale(0.4)"}
     (marcup/md "")
     [:g {:transform "scale(0.9)"}
      (fo/fo {:style {:color (color/palette 0)}}
             (marcup/marcup "```
  [:circle {:r 3 :cx  -8 :cy -10 :fill \"black\"}]
  [:circle {:r 3 :cx   8 :cy -10 :fill \"black\"}]
  [:circle {:r 4 :cx   0 :cy   0 :fill \"orange\"}]
  [:circle {:r 2 :cx   0 :cy  10 :fill \"gray\"}]
  [:circle {:r 2 :cx  -7 :cy   8 :fill \"gray\"}]
  [:circle {:r 2 :cx -12 :cy   4 :fill \"gray\"}]
  [:circle {:r 2 :cx   7 :cy   8 :fill \"gray\"}]
  [:circle {:r 2 :cx  12 :cy   4 :fill \"gray\"}]
```"))]]
   [:g {:fill (color/palette 0) :transform "translate(300, 50)"}
    [:circle {:r 20}]
    [:circle {:r 30 :cy 45}]
    [:circle {:r 40 :cy 105}]

    [:circle {:r 3 :cx  -8 :cy -10 :fill "black"}]
    [:circle {:r 3 :cx   8 :cy -10 :fill "black"}]
    [:circle {:r 4 :cx   0 :cy   0 :fill "orange"}]
    [:circle {:r 2 :cx   0 :cy  10 :fill "gray"}]
    [:circle {:r 2 :cx  -7 :cy   8 :fill "gray"}]
    [:circle {:r 2 :cx -12 :cy   4 :fill "gray"}]
    [:circle {:r 2 :cx   7 :cy   8 :fill "gray"}]
    [:circle {:r 2 :cx  12 :cy   4 :fill "gray"}]

    ]])

(def stroke
  [:g {:data-title ""}
   (marcup/md "Stroke and fill

```
[:circle {:r            20
          :fill         \"green\"
          :stroke       \"red\"
          :stroke-width 3}]
```")
   [:circle {:r            20
             :cx           250
             :cy           180
             :fill         "green"
             :stroke       "red"
             :stroke-width 3}]])

(def slides
  (util/arrange "How"
                [aliens/smart 0 200]
                [what-is-svg 400 0]
                [what-is-hiccup 800 0]
                [snowman 0 300]
                [fill 400 300]))
