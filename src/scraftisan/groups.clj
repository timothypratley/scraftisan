(ns scraftisan.groups
  (:require [scraftisan.aliens :as aliens]
            [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def g
  [:g {:data-title ""}
   (marcup/md "```
[:g {:fill \"yellow\"
     :stroke \"green\"
     :stroke-width 4}
    [:circle {:r 20}]
    [:circle {:cx 50 :r 20}]]
```")
   [:g {:transform "translate(250,180)"
        :fill      "yellow"
        :stroke    "green"
        :stroke-width 4}
    [:circle {:r 20}]
    [:circle {:cx 50 :r 20}]]])

(def transform
  (let [heart (list [:text "🤍"] [:text "🔹"])]
    [:g {:data-title ""}
     (marcup/md "```



[:g [:text \"🤍\"] [:text \"🔹\"]]

[:g {:transform \"rotate(30)\"} …]

[:g {:transform \"scale(2, 0.8)\"} …]

[:g {:transform \"translate(0, 20)\"} …]
```")
     [:g {:transform "translate(320, 80)"}
      [:g {:transform ""} heart]
      [:g {:transform "translate(0,30)  rotate(30)"} heart]
      [:g {:transform "translate(0,60)  scale(2, 0.8)"} heart]
      [:g {:transform "translate(0,90)  translate(20, 0)"} heart]]]))

(def slides
  (util/arrange "Groups"
                [aliens/stalks 0 200]
                [g 400 0]
                [transform 800 0]))
