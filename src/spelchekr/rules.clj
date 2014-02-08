(ns spelchekr.rules
  (:require [clojure.string :as string]))

;;; A simple spell checker that works by recognizing
;;; valid words. Each known word is stored in a simple dictionary. 
;;; The algorithm is trained by the user by providing us with sets of words.
;;;
;;; Note that this algorithm is quite limited. For example, it only
;;; does exact matches and doesn't take any word proximity into account.

;;; We represent all known words as a set and encapsulates that
;;; knowledge in this module. The user retrieves the initial, empty set
;;; through this symbol:
(def ^:constant initial-knowledge #{}) 

(defn check
  "Returns a truthy value in case the given word is amongst the
   known set of words.
   Since Clojure sequences are also functions of their values
   the implemetation couldn't be much simpler."
  [word known?]
  (->
  (string/lower-case word)
  known?))

(defn extend-knowledge
  "Extends the known set of words with the new word.
   The new context representing the extended rules is returned."
  [known new-word]
  (->>
   (string/lower-case new-word)
   (merge known)))

  
