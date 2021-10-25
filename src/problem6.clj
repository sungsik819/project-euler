(ns problem6
  (:require [utils :as u]))

(defn solution6 [a b]
  (let [sqrt-sum (apply + (map #(* % %) (range a (inc b))))
        sum (apply + (range a (inc b)))
        sum-sqrt (* sum sum)]
    (- sum-sqrt sqrt-sum)))

;; 25164150
(solution6 1 100)

;; 참고
;; https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kyh941031&logNo=221630500355
(defn solution6-1 [n]
  (quot (* n (* (+ n 1)
                  (- n 1)
                  (+ (* 3 n) 2))) 12))

(solution6-1 100)

;; https://ntalbs.github.io/2015/project-euler-006/

(defn square-sum [n]
  (quot (* n (+ 1 n) (+ 1 (* 2 n))) 6))

(- (* (u/sum 100) (u/sum 100)) (square-sum 100))
