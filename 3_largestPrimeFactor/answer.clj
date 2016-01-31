;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143 ?


;; Basically, the idea is to remove prime factors from the number's prime factorization. If 2
;; divides the number, remove all instances of 2 from the prime factorization. If 3 does as well, then
;; also remove those. Because you've removed 2 and 3, it stands to reason that you've also removed all
;; non-primes for which 2 and 3 are divisors. Therefore, any factor removed from the number will be
;; prime, and the last number will be the largest such prime.

;; This implementation overflows easily with nubmers > 6 digits long because of clojure's (jvm's)
;; lack of tail-call optimization.
(defn largest-prime-factor
  ([number]
   (largest-prime-factor number 2))
  ([number potential-factor]
   (if (<= number 1)
     potential-factor
     (if (= (rem number potential-factor) 0)
       (largest-prime-factor
        (/ number potential-factor) potential-factor)
       (largest-prime-factor number (inc potential-factor))))))


; Same algorithm, except this implemention recurses using the recur key word to allow for
; tail-call optimization by clojure.
(defn largest-prime-factor-v2
  ([number]
   (largest-prime-factor-v2 number 2))
  ([n pf]
     (if (<= n 1)
       pf
       (if (= (rem n pf) 0)
         (recur (/ n pf) pf)
         (recur n (inc pf))))))
