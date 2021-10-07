(ns utils)

;; 약수 구하기
(defn divisor [n]
  (let [max (inc (Math/sqrt n))]
    (->>
     (filter #(= (rem n %) 0) (range 1 max))
     (reduce #(conj %1 %2 (quot n %2))
             [])
     (set)
     (sort))))

;; 원래 수 와 약수의 조합
;; 원래수가 10이고 약수가 4개일때
;; [10 4]가 된다.
(defn div-cnt [d]
  (let [div (divisor d)
        cnt (count div)]
    [d cnt]))

;; n번째 소수 구하기
(defn n-prime [n]
  (->> (map div-cnt (range))
       (filter #(= 2 (second %)))
       (take n)
       (last)
       (first)))

;; 최대 공약수
(defn gcd [a b]
  (loop [r (rem a b)
         a b]
    (if (zero? r) a
        (recur (rem a r) r))))

;; 절대값
(defn abs [n]
  (max n (-' n)))

;; 최소 공배수
(defn lcm [a b]
  (quot (abs (* a b)) (gcd a b)))

;; 순차적인 n개의 숫자의 최소공배수 구하기
(defn n-lcm [a b]
  (reduce #(if (>= (lcm %1 %2) %1) (lcm %1 %2) %2)
          (range a (inc b))))

(defmacro sectime
  [expr]
  `(let [start# (. System (currentTimeMillis))
         ret# ~expr]
     (prn (str "Elapsed time: " (/ (double (- (. System (currentTimeMillis)) start#)) 1000.0) " secs"))
     ret#))