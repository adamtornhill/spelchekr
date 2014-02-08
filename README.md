# spelchekr

A simple spell checker used to introduce Clojure.

## Topics

By devloping this program we get to introduce the core of Clojure such as:

* Sequences and higher-order functions.
* Code as data (although just by our macro usage where we inspect existing macros).
* Programming with the absence of conditional logic (what's not here is just as important as what we include).
* Basic unit testing.
* Interactive development using the REPL.
* Mutable state in a functional language.
* Side-effects (file I/O).

## Usage

The idea here is to get a feel for development in Clojure rather than focusing on algorithms for spell checking. As such, I wouldn't use this library for any other purpose.

Given that disclaimer, here's how to a session with the spell checker looks:

    spelchekr.core> (train-by "Hello there these are some, words.")
    #{"these" "there" "words" "hello" "some" "are"}
    spelchekr.core> (train-by "Hello there these are some more words for you.")
    #{"these" "there" "for" "words" "hello" "some" "are" "more" "you"}
    
    spelchekr.core> (spelling-errors-in "Some sentence for you.")
    ("sentence") ; the errors are returned in a seq
    spelchekr.core> (train-by "Define sentence.")
    #{"sentence" "these" "there" "for" "words" "hello" "some" "are" "more" "define" "you"}
    spelchekr.core> (spelling-errors-in "Some sentence for you.")
    () ; no errors - empty seq
    
    ;;; We can also train it by direct file input:
    spelchekr.core> (train-by-file "training_data.txt")

## License

Copyright © 2014 Adam Tornhill

Distributed under the Eclipse Public License, the same as Clojure.
