(ns scraftisan.marcup
  (:require [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as mdt]
            [scraftisan.color :as color]
            [scraftisan.util :as util]))

(def mdctx
  (assoc mdt/default-hiccup-renderers
    :plain (fn [ctx {:keys [text content]}]
             (or text (map #(mdt/->hiccup ctx %) content)))))

(defn marcup
  "Hiccup doesn't support fragments [:<> ...], but does support seq fragments.
  We render fragments as seqs, so they can be converted correctly by hiccup."
  [s]
  (md/->hiccup mdctx s))

(defn fo [props & body]
  [:foreignObject {:width      "400"
                   :height     "200"
                   :style  {:overflow "visible"}}
   (into [:div (util/deep-merge {:xmlns "http://www.w3.org/1999/xhtml"}
                                props)]
         body)])

(defn mo [s]
  (fo {:style {:width         "350px"
                  :min-height    "200px"
                  :background    (color/palette 0)
                  :border        (str "solid 3px " (color/palette 10))
                  :border-radius "10px"
                  :padding       "10px"}}
         (marcup s)))

(defn md [s]
  (fo {:style {:width         "350px"
                  :min-height    "200px"
                  :color         (color/palette 0)
                  :background    (color/palette 12)
                  :border        (str "solid 3px " (color/palette 11))
                  :border-radius "10px"
                  :padding       "10px"}}
         (marcup s)))

(def markdown-example
  [:g {:data-title "markdown example"}
   (mo "## This is **markdown**

\"## This is **markdown**\"

-> `nextjournal/markdown` -> hiccup

-> `[:foreignObject ...]`")])

(def slides
  (util/arrange "Markdown in SVG"
                [markdown-example 400 0]))
