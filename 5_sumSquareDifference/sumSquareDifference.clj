;; The square of sums of of a set of nummbers, say a,b,c, d, is equal to the sum of squares
;; (call it f) plus two times the sum of all combinations of two numbers (e.g., the square of sums
;; is equal to f + 2(ab + ac + ad + bc + bd + cd), so the difference is 2(ab + ac + ad + bc + bd + cd))

;; for the set nums=[a,b,c,d], this method ultimately returns ((ab+ac+ad)+(bc+bd)+(cd)) =
;; ((a*(b+c+d) + b*(c+d) + c*(d))


;; This solution is acceptable for intended input. It will stackoverflow for large input.
(defn sum-combinations
  "Sums all combinations of two numbers in the list.
  E.g., [a b c d] = (ab + ac + ad + bc + bd + cd) = (a*(b+c+d) + b(c+d) + c(d))"
  [[head & tail]]
  (if (nil? tail)
    0
    (+ (sum-combinations tail) (* head (reduce + tail)))))

;; This is a less concise, but more much more space-efficient solution.
(defn sum-combinations-v2
  "Sums all combinations of two numbers in the list.
  E.g., [a b c d] = (ab + ac + ad + bc + bd + cd) = (a*(b+c+d) + b(c+d) + c(d))"
  ([numbers]
   (sum-combinations-v2 numbers 0))
  ([[head & tail] acc]
   (if (nil? tail)
     acc
     (recur tail (+ acc (* head (reduce + tail)))))))


(defn squares-sum-sum-squares-diff
  "The difference between the square of the sum and the sum of the squares of a particular list
  is the sum of all permutations of two numbers in the list, which is equal to 2 times the sum
  of all combinations of two numbers in the list."
  [num]
  (* 2 (sum-combinations-v2 (take num (iterate inc 1)))))
