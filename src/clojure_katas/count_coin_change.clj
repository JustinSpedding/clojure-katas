(ns clojure-katas.count-coin-change
  (:require [clojure-katas.core :as core]))

(def coins [1 5 10 25 50])

(defn number-of-ways [sum coins]
  (cond
    (empty? coins) 0
    (neg? sum) 0
    (zero? sum) 1
    (pos? sum) (+ (number-of-ways (- sum (first coins)) coins)
                  (number-of-ways sum (rest coins)))))

(core/defproblem count-coin-change-tree
  "
  Reference: SICP
  How many different ways can we make change of $1.00, given half-dollars, quarters, nickels, and pennies?
  More generally, can we write a procedure to compute the number of ways to change any given amount of money?

  Solution 1 build tree recursion
  # of ways to change amount a using n kinds of coins =
    # of ways to change amount a using all but first kind of coin +
    # of ways to change amount a - d, where d is the denomination of the first kind of coin"
  [amount, index-of-coin-change-array]
  (number-of-ways amount (into '() coins)))
