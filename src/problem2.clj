;; 피보나치 수열 만들기
(defn fib [f s]
  (lazy-seq (cons f (fib s (+ f s)))))

(->> (take 50 (fib 0 1))
     (filter #(< % 4000000))
     (filter #(= (mod % 2) 0))
     (reduce + ))

;; 피보나치 수열 만드는 다른 방법
(defn fibo-iter []
  (->> (iterate (fn [[a b]] [b (+ a b)]) [1 1])
       (map first)))

(->> (fibo-iter)
     (filter even?)
     (take-while #(<= % 4000000))
     (apply +))