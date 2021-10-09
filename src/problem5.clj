(ns problem5
  (:require [utils :as u]))

;; 순차적인 n개의 숫자의 최소공배수 구하기
(defn n-lcm [a b]
  (reduce #(if (>= (u/lcm %1 %2) %1) (u/lcm %1 %2) %2)
          (range a (inc b))))

;; => 232792560
(u/sectime(n-lcm 1 19))