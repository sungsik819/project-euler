(ns problem12
  (:require [utils :as u]))

;; 삼각수의 성질
;; n번째 수를 구하기 위해서는 이전 숫자에 n을 더한다.
;; 예) 2번째 수를 구하려면 1 + 2로 3이 된다.

(defn triangle-number [end]
  (->>
   (range 1 (inc end))
   (apply +)))

;; https://m.blog.naver.com/kyh941031/221641016407
(defn triangle-number2 [end]
  (quot (* end (+ end 1)) 2))

;; 76576500
;; 오래 걸림
;; 범위를 맞춰서 찾느라 몇번 틀림
(->>
            (map #(triangle-number %) (range 10000 100000))
            (map #(vector % (count (u/divisor %))))
            (filter #(<= 500 (last %))))