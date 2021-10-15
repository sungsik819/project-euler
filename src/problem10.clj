(ns problem10
  (:require [utils :as u]))


;; 에라토스테네스의 체로 계산
;; Elapsed time: 3.702 secs
;; 142913828922
(u/sectime (apply + (u/sieve-of-eratostenes 2000000)))