;;
;; Largest prime factor
;; Problem 3
;;
;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143 ?
;;

(define (problem3 number)
 (problem3-iter number 2))

(define (problem3-iter number denumber)
 (cond ((= number denumber) number)
  ((= (remainder number denumber) 0)(problem3-iter (/ number denumber) denumber))
  (else (problem3-iter number (+ denumber 1)))))
