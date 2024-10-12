(ns scraftisan.groups
  (:require [scraftisan.color :as color]
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
  (util/arrange [g 0 0]
                [transform 400 0]
                [stroke 0 300]))
