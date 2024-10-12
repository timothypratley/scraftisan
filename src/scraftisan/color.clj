(ns scraftisan.color
  (:require [clojure.string :as str]
            [scraftisan.util :as util]))

(def palette
  ["#FCFFE0"                                                ;  0
   "#D0F040"                                                ;  1
   "#E6E6FA"                                                ;  2
   "#D0F7FF"                                                ;  3
   "#FCECC5"                                                ;  4
   "#FCE2F7"                                                ;  5
   "#E0FFD0"                                                ;  6
   "#F0D0E0"                                                ;  7
   "#40D0A0"                                                ;  8
   "#FF8080"                                                ;  9
   "#F0F0C8"                                                ; 10
   "#AFA050"                                                ; 11
   "#040622"                                                ; 12
   ])

(defn palette-view [p]
  (let [w 32
        h 32]
    (->> (partition-all 3 p)
         (map-indexed (fn [y row]
                        (->> (map-indexed (fn [x color]
                                            [:path {:transform (str "translate(" (* (- x 1) w 2) " " (* (- y 1) h 2) ")")
                                                    :fill      color
                                                    :d         (str/join " " ['M (- w) (- h)
                                                                              'L w (- h) w h (- w) h
                                                                              'Z])}])
                                          row)
                             (into [:g]))))
         (into [:g {}]))))

(def choosing-colors
  [:g {:data-title ""}
   (palette-view ["red" "green" "blue" "yellow"])])

(def pp
  [:g {:data-title ""}
   (palette-view palette)])

(def slides
  (util/arrange [choosing-colors 0 0]
                [palette-view 300 0]))
