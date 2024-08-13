(ns scraftisan.marcup
  (:require [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as mdt]
            [scraftisan.html-in-svg :as fo]))

(def mdctx
  (assoc mdt/default-hiccup-renderers
    :plain (fn [ctx {:keys [text content]}]
             (or text (map #(mdt/->hiccup ctx %) content)))))

(defn marcup
  "Hiccup doesn't support fragments [:<> ...] yet, but does support seq fragments.
  We render fragments as seqs, so they can be converted correctly by hiccup."
  [s]
  (md/->hiccup mdctx s))

(defn markdown-example []
  (fo/fo {:style {:width "100%"}}
      (marcup "## This is **markdown**
* Because we like markdown
* It's nice")))

#_(svg/svg (markdown-example))

(defn making-use-of-svg []
  (fo/fo {:style {:width "100%"}}
      (marcup "## Making use of existing SVG
* Converting SVG (XML) to hiccup
* Cursive offers to do it when you copy paste
* Does emacs?
* Font awesome SVGs are useful (https://fontawesome.com/search?q=code&o=r&m=free&f=classic)
* Copy the SVG code, and paste it into hiccup")))
