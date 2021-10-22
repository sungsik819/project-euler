(ns problem1
  (:require [utils :as u]))

(->> (range 1000)
     (filter #(or (zero? (mod % 3))
                  (zero? (mod % 5))))
     (apply +))
     

(- (+ (u/sum 999 5) (u/sum 999 3)) (u/sum 999 15))
