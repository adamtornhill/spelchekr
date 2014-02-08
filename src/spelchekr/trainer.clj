(ns spelchekr.trainer
  (:require [clojure.string :as string]))

(defn- strip-terminators
  "Remove all non-word characters for the given input word.
  Note that this is quite a rough approach. But it's a good
  start and we can always grow it later."
  [word]
  (string/replace word #"[^\w]" ""))

(defn words-from
  [lines]
  (->>
   (string/split lines #"\s")
   (map strip-terminators)))

(defn teach
  "Teachers the learner all new words.
   The new knowledge will be combined with the already-known words.
   Returns the new, combined knowledge."
  [words learner already-known]
  (reduce learner already-known words))

