
(define (problem4)
 (problem4-iter 500 500 1 10))

(define (ispalindrome? number)
 (palindrome-iter number 0))

(define (palindrome-iter number partial)
 (if (= number 0) partial 
  (palindrome-iter (quotient number 10) (+ (* partial 10) (remainder number 10)))))

  
(define (problem4-iter oneindex twoindex result value)
 (cond ((and (>= twoindex 999) (>= oneindex 999)) result)
  ((and (> value result) (= (ispalindrome? value) value)) 
     (problem4-iter (+ oneindex 1) twoindex value (* (+ oneindex 1) twoindex)))
  ((>= oneindex 999) (problem4-iter 1 (+ twoindex 1) result (* 1 (+ twoindex 1))))
  (else (problem4-iter (+ oneindex 1) twoindex result (* (+ oneindex 1) twoindex)))))
    
