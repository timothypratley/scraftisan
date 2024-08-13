(ns scraftisan.color
  (:require [clojure.string :as str]))

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


(defn palette-view []
  (let [w 32
        h 32]
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

#_(svg (palette-view))
