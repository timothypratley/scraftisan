(ns scraftisan.marcup
  (:require [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as mdt]
            [scraftisan.color :as color]
            [scraftisan.html-in-svg :as fo]
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

(defn mo [s]
  (fo/fo {:style {:width         "350px"
                  :min-height    "200px"
                  :background    (color/palette 0)
                  :border        (str "solid 3px " (color/palette 10))
                  :border-radius "10px"
                  :padding       "10px"}}
         (marcup s)))

(defn md [s]
  (fo/fo {:style {:width         "350px"
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
* Because we like markdown
* It's nice")])

(def making-use-of-svg
  [:g {:data-title "making use of svg"}
   (mo "## Making use of existing SVG
* [fontawesome.com](https://fontawesome.com/search?q=code&o=r&m=free&f=classic)
* [svgrepo.com](https://www.svgrepo.com/vectors/elephant/)
* `<image href=\"...\">`
* Cursive and Calva
* SVG to hiccup [html2hiccup](http://html2hiccup.buttercloud.com/)")])

(def slides
  (util/arrange "Markdown in SVG"
                [markdown-example 400 0]
                [making-use-of-svg 800 0]))
