(defn fib [f s]
  (lazy-seq (cons f (fib s (+ f s)))))

(->> (take 50 (fib 0 1))
     (filter #(< % 4000000))
     (filter #(= (mod % 2) 0))
     (reduce + ))
