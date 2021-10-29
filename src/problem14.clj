(ns problem14
  (:require [utils :as u]))


(defn hailstone-sequence-count [n]
  (loop [cnt 1
         n n]
    (if (= n 1) cnt
        (recur (inc cnt)
               (if (even? n)
                 (quot n 2)
                 (+ (* 3 n) 1))))))

;; [837799 525]
(u/sectime (last (sort #(compare (last %1) (last %2))
                       (map #(vector % (hailstone-sequence-count %))
                            (range 10 1000000)))))

