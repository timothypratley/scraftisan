(ns scraftisan.hiccup
  (:require [hiccup2.core :as hiccup2]))

(defn expand
  "Sadly hiccup is not as standardized as you might hope.
  Fragments (:<>) produced by nextjournal markdown but considered a tag by hiccup.
  So we convert them to seqs which are handled by hiccup.
  Alternatively we could use a different hiccup implementation,
  or try to push for an upstream change (https://github.com/weavejester/hiccup/issues/164)."
  [hiccup]
  (if (vector? hiccup)
    (let [[tag & children] hiccup]
      (cond (fn? tag) (apply tag children)
            (#{:<>} tag) children
            :else (let [c (first children)
                        attrs (and (map? c) c)]
                    (if attrs
                      (into [tag attrs] (map expand) (rest children))
                      (into [tag] (map expand) children)))))
    hiccup))

(defn html [hiccup]
  (hiccup2/html (expand hiccup)))
