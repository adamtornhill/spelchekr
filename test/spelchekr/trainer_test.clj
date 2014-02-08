(ns spelchekr.trainer-test
  (:require [spelchekr.trainer :as trainer]
            [spelchekr.rules :as rules])
  (:use clojure.test))

(deftest parsers-words-from-lines
  (is (= (trainer/words-from "hello there")
         ["hello" "there"])))

(deftest strips-terminators-from-words
  (is (= (trainer/words-from "yes; this works.\n")
         ["yes" "this" "works"])))

;;; So, to glue it together we need some learner who's
;;; knowledge we'll extend. Using Clojure we can mock
;;; it up quite easily. However, I don't see much point
;;; in that - let's just use the real rules:
(deftest teaching-extends-learners-knowledge
  (is (= (trainer/teach ["new" "words"] rules/extend-knowledge rules/initial-knowledge)
         #{"new" "words"}))) ; leaky?
