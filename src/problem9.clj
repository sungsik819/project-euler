(ns problem9)

;;3,4,5 = 12

(defn square [x]
  (* x x))

;; a < b < c 이면서
;; a^2 + b^2 = c^2 인데
;; a+b+c = 1000인 값이 무엇이 있을까?
;; 순차적으로 순회하는 방법(범위를 좁혀서 결과를 빠르게 나오게 한다.)
(for [a (range 200 500)
      b (range 300 500)
      c (range 400 500)
      :when (and (< a b c) 
                 (= (+ (square a) (square b)) (square c))
                 (= 1000 (+ a b c)))]
  (* a b c))

;; https://m.blog.naver.com/kyh941031/221636810763 보면서 만드는중
(let [Ns (Math/pow 1000 2)]
  (reduce #(if (zero? (mod Ns %2)) (conj %1 [(- 1000 Ns) (- 1000 %2) (- 1000 (- 1000 Ns))]) %1) [] (range (Math/floor (+ 1 (quot 1000 2)))
                               (inc (Math/ceil (- (quot 1000 (Math/pow 2 0.5)) 1))))))