(ns solution4)

;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn reverse-number [number]
  (loop [p 0
         temp number]
    (if (= temp 0) p
        (recur (+ (* p 10) (rem temp 10))
               (quot temp 10)))))

;; 이 값의 답 906609
(last (filter #(= (reverse-number %) %)
              (for [i (range 900 999)
                    j (range 900 999)
                    :let [n (* i j)]]
                n)))