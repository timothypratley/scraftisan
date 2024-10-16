(ns scraftisan.better
  (:require [scraftisan.marcup :as marcup]
            [scraftisan.util :as util]))

(def prelude
  [:g {:data-title ""
       :fill "#000000"}
   [:path {:d "M11.835 8.827a2.648 2.648 0 0 1-3.381 3.964 3.734 3.734 0 0 1-6.686-2.29c0-.099.008-.195.015-.292a3.734 3.734 0 1 1 4.42-6.017 3.662 3.662 0 0 1 5.632 4.635zm-7.434-.265a.803.803 0 0 0-.811-.867.813.813 0 0 0-.826.867.82.82 0 1 0 1.637 0zm2.846 0a.802.802 0 0 0-.811-.867.813.813 0 0 0-.825.867.82.82 0 1 0 1.636 0zm2.847 0a.802.802 0 0 0-.812-.867.813.813 0 0 0-.825.867.82.82 0 1 0 1.637 0zm2.58 6.691a1.141 1.141 0 1 1 1.141-1.141 1.141 1.141 0 0 1-1.14 1.141z"}]])

(def thinking
  (marcup/mo "Thinking

* Dialog
* Writing
* Diagrams"))

(def better
  (marcup/mo "Every problem is a knowledge search problem.
...
The right knowledge can solve any problem."))

(def knowledge
  (marcup/mo "Knowledge

> facts, information, and skills
> acquired by a person through experience or education;
> the theoretical or practical understanding of a subject."))

(def graphs
  (marcup/mo "Everything is a graph

> A set of things
> and a set of relations between them

The easiest way to make a graph is to make a diagram."))

(def slides
  (util/arrange "Better"
                [prelude 0 0]
                [thinking 400 0]
                [better 800 0]
                [knowledge 1200 0]
                [graphs 1600 0]))
