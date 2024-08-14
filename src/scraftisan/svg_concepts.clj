(ns scraftisan.svg-concepts
  (:require [scicloj.kindly.v4.kind :as kind]
            #_[scraftisan.marcup :as marcup]
            [scraftisan.color :as color]))


#_(marcup/marcup "Xml namespace is a required

```html
    <svg xmlns=\"http://www.w3.org/2000/svg\">
    …
    </svg>
```

We love Hiccup

```clojure
    [:svg {:xmlns \"http://www.w3.org/2000/svg\"} …]
```")


(defn svg [& body]
  (kind/hiccup
    (into [:svg {:height  "100%"
                 :width   "100%"
                 :viewBox [-127 -127 256 256]
                 :xmlns   "http://www.w3.org/2000/svg"}
           [:rect {:fill   (color/palette 0)
                   :stroke (color/palette 11)
                   :x      -127
                   :y      -127
                   :width  256
                   :height 256
                   :rx     4}]]
          body)))
