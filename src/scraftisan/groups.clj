(ns scraftisan.groups
  (:require [scraftisan.aliens :as aliens]
            [scraftisan.color :as color]
            [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def g
  [:g {:data-title ""}
   (marcup/md "Groups
```
[:g [:circle {:r 20}]
    [:circle {:cx 50 :r 20}]]
```

```
[:g {:transform ...
     :stroke    ...
     :fill      ...}
```")
   [:g {:transform "translate(250,180)"
        :fill      (color/palette 0)}
    [:circle {:r 20}]
    [:circle {:cx 50 :r 20}]]])

(def transform
  [:g {:data-title ""}
   (marcup/md "Transforms

* translate(x,y)
* scale(x,y)
* rotate(deg)
* rotate(deg,x,y)

```
[:g {:transform \"translate(10,10) rotate(15)\"} ...]
```")])

(def slides
  (util/arrange "Groups"
                [aliens/stalks 0 200]
                [g 400 0]
                [transform 800 0]))
