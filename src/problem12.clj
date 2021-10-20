(ns problem12
  (:require [utils :as u]))

;; 삼각수의 성질
;; n번째 수를 구하기 위해서는 이전 숫자에 n을 더한다.
;; 예) 2번째 수를 구하려면 1 + 2로 3이 된다.
(defn sum-one-to-n2 [end]
  (->>
   (range 1 (inc end))
   (apply +)))

;; https://m.blog.naver.com/kyh941031/221641016407
;; 1부터 n까지 합
(defn sum-one-to-n [n]
  (quot (* n (+ n 1)) 2))

(defn count-divisor [n]
  (count (u/divisor n)))

;; 삼각수 약수의 갯수 구하기
(defn count-triangle-divisor [n]
  (if (zero? (rem n 2))
    (* (count-divisor (quot n 2)) (count-divisor (inc n)))
    (* (count-divisor n) (count-divisor (quot (inc n) 2)))))

;; 약수가 n개인 삼각수 중 제일 작은 수
(defn triangle-divisor [n]
  (let [[a] (->> (range) 
                 (filter #(when (<= n (count-triangle-divisor %)) %))
                 (take 1))]
    (* a (quot (inc a) 2))))

(u/sectime (triangle-divisor 500))

;; 76576500
;; 오래 걸림
;; 범위를 맞춰서 찾느라 몇번 틀림
(->>
            (map #(sum-one-to-n %) (range 12370 12380))
            (map #(vector % (count (u/divisor %))))
            (filter #(<= 500 (last %))))