(ns scraftisan.art
  (:require [scraftisan.util :as util]))

(def willie
  [:g {:data-title ""}
   [:image {:href  "images/willie-gillis-in-college-1946.jpg"
            :width 200}]])

(def vincent
  [:g {:data-title ""}
   [:image {:href  "images/Vincent_van_Gogh__Self_portrait.jpg"
            :width 200}]])

(def pablo
  [:g {:data-title ""}
   [:image {:href  "images/PabloPicasoSelfPotrait.webp"
            :width 200}]])

(def monet
  [:g {:data-title ""}
   [:image {:href  "images/Bridge_Over_a_Pond_of_Water_Lilies,_Claude_Monet_1899.jpg"
            :width 200}]])

(def wall
  [:g {:data-title ""}
   [:image {:href  "images/photo-wall.jpg"
            :width 1000}]])

(def slides
  (util/arrange "Art"
                [willie 0 0]
                [vincent 250 0]
                [pablo 500 0]
                [monet 750 0]
                [wall -25 300]))
