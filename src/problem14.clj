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

;; https://m.blog.naver.com/PostView.naver?blogId=kyh941031&logNo=221642965946&navType=by 참고
;; 홀수 다음에 무조건 짝수 이므로 다음에는 반드시 2를 나누는 식이 들어간다 
;; 그러므로 홀수 일때 미리 2로 나눠준다.
;; 홀수일때는 카운트 수를 2 증가 한다.
(defn hailstone-sequence-count2 [n]
  (loop [cnt 1
         n n]
    (if (= n 1) cnt
        (recur (if (even? n) (inc cnt) (+ cnt 2))
               (if (even? n)
                 (quot n 2)
                 (quot (+ (* 3 n) 1) 2))))))


;; [837799 525]
(u/sectime (last (sort #(compare (last %1) (last %2))
                       (map #(vector % (hailstone-sequence-count %))
                            (range 10 1000000)))))

