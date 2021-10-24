(ns problem4
  (:require [utils :as u]))

;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

;; 이 값의 답 906609
(u/sectime (apply max (filter #(= (u/reverse-number %) %)
                              (for [i (range 100 999)
                                    j (range 100 999)
                                    :let [n (* i j)]]
                                n))))

(u/sectime (apply max (filter #(= (u/reverse-number %) %)
                              (for [i (range 100 999)
                                    j (range 100 999)
                                    :when (or (zero? (mod i 11)) (zero? (mod j 11)))]
                                (* i j)))))