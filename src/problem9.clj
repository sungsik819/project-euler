(ns problem9
  (:require [utils :as u]))

;; a < b < c 이면서
;; a^2 + b^2 = c^2 인데
;; a+b+c = 1000인 값이 무엇이 있을까?
;; 순차적으로 순회하는 방법(범위를 좁혀서 결과를 빠르게 나오게 한다.)
(for [a (range 200 500)
      b (range 300 500)
      c (range 400 500)
      :when (and (< a b c) 
                 (= (+ (u/square a) (u/square b)) (u/square c))
                 (= 1000 (+ a b c)))]
  (* a b c))

;; for 2번 사용하여 구현
(->> (for [b (range 1 1000)
           a (range 1 b)]
       (let [c (- 1000 a b)]
         (when (= (+ (u/square a) (u/square b)) (u/square c))
           [a b c])))
     (remove #(= nil %)))

;; https://m.blog.naver.com/kyh941031/221636810763 참고
(->>
 (u/pythagorean-triple 1000)
 (apply *))