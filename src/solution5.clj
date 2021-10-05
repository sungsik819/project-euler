(ns solution5)

;; 약수 구하기 - 사용 안함
(defn reminders [n]
  (let [max (inc (Math/sqrt n))]
    (->>
     (filter #(= (rem n %) 0) (range 1 max))
     (reduce #(conj %1 %2 (quot n %2))
             [])
     (set)
     (sort))))

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

(n-lcm 1 19);; => 232792560