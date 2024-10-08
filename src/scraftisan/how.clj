(ns scraftisan.how
  (:require [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]
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

namespace is a required

Hiccup

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

(def slides
  (util/arrange [[what-is-svg 0 0]
                 [what-is-hiccup 400 0]]))
