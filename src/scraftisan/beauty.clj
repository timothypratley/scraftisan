(ns scraftisan.beauty
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
  (util/arrange "Beauty"
                [wall 375 0]
                [willie 400 450]
                [pablo 650 450]
                [vincent 900 450]
                [monet 1150 450]))
