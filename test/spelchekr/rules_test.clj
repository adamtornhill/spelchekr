(ns spelchekr.rules-test
  (:require [spelchekr.rules :as rules])
  (:use clojure.test))

(defn- knows
  "A starting point for tests that need
   a pre-defined rule."
  [word]
  (rules/extend-knowledge rules/initial-knowledge word))

(deftest detects-invalid-words
  (is (not (rules/check "something" rules/initial-knowledge))))

(deftest is-trained-by-the-user
  (let [new-knowledge (rules/extend-knowledge rules/initial-knowledge "something")]
    (is (rules/check "something" new-knowledge))))

(deftest check-is-case-insensitive
  (is (rules/check "cAsEiNsEnSiTiVe"
                   (knows "caseinsensitive"))))
