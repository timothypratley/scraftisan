(ns scraftisan.conclusion
  (:require [scraftisan.util :as util]))

(def conclusion
  [:g {:data-title ""}])

(def slides
  (util/arrange "Conclusion"
                [conclusion 0 0]))
