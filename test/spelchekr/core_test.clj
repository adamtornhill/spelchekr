(ns spelchekr.core-test
  (:require [spelchekr.core :as core])
  (:use clojure.test))

;;; This module contains end-to-end tests using the
;;; core entry points of the application.

(def ^:constant raw-text "Just some random words.")

(defn with-predefined-knowledge
  "A fixture applied to each test case.
   Since our code is stateful we now need
   this additional complexity (see, state hurts).
   We just forget everything from previous test cases,
   if anything at all, and re-learn from our hard-coded
   raw text."
  [f]
  (core/forget-everything!)
  (core/train-by raw-text)
  (f))

(use-fixtures :each with-predefined-knowledge)

(deftest finds-spelling-errors-in-sentences
  (testing "single errors"
    (is (= (core/spelling-errors-in "Some randmm words.")
           ["randmm"])))
  (testing "muliple errors"
    (is (= (core/spelling-errors-in "Muplipl faltts")
           ["Muplipl" "faltts"])))
  (testing "no errors - perfect spelling"
    (is (= (core/spelling-errors-in raw-text)
           []))))
