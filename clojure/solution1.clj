(->> (range 1000)
     (filter #(or (= (mod % 3) 0)
                  (= (mod % 5) 0)))
     (apply +))

