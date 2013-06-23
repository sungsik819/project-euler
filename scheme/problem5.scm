(define (problem5)
 (problem5-iter 1))

(define (problem5-iter index)
 (if (and (= (remainder index 8) 0) (= (remainder index 9) 0)
      (= (remainder index 7) 0) (= (remainder index 5) 0)) index
  (problem5-iter (+ index 1))))
