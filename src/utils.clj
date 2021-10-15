(ns utils)

;; 제곱
(defn square [x]
  (* x x))

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
       (filter (fn [[_ c]] (= 2 c)))
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

;; 숫지 뒤집기
(defn reverse-number [number]
  (loop [p 0
         temp number]
    (if (= temp 0) p
        (recur (+ (* p 10) (rem temp 10))
               (quot temp 10)))))

;; a + b + c가되는 N으로 피타고라스의 수 구하기
;; https://m.blog.naver.com/kyh941031/221636810763 참고
(defn pythagorean-triple [N]
  (let [lower (+ 1 (Math/floor (quot N 2)))
        upper (Math/ceil (quot N (Math/pow 2 0.5)))
        Ns (Math/pow N 2)
        py-quot (partial quot Ns)]
    (->>
     (range lower upper)
     (filter #(zero? (mod Ns %)))
     (map #(let [a (int (- N (py-quot (* % 2))))
                 b (int (- N %))
                 c (int (- % a))]
             [a b c])))))

;; (sieve-of-eratostenes 600851475143) stackoverflow error
;; 에라토스테네스의 체 (n번째 숫자안의 소수를 구하기 위한 방법)
(defn sieve-of-eratostenes [^long n]
  (let [max-lange (long (Math/sqrt n))]
    (loop [a (range 2 (inc n))
           n (long (first a))
           r []]
      (if (> n max-lange) (seq (into r a))
          (recur (remove #(zero? (mod % n)) a)
                 (first (remove #(zero? (mod % n)) a))
                 (conj r n))))))

;; n의 인수
(defn factors [^long n]
  (seq (reduce #(if (zero? (mod n %2))
                  (conj %1 %2)
                  %1)
               [] (sieve-of-eratostenes n))))

(defmacro sectime
  [expr]
  `(let [start# (. System (currentTimeMillis))
         ret# ~expr]
     (prn (str "Elapsed time: " (/ (double (- (. System (currentTimeMillis)) start#)) 1000.0) " secs"))
     ret#))