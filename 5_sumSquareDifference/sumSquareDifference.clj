;; This solution is acceptable for intended input. It will stackoverflow for large input.
(defn sum-combinations
  "Sums all combinations of two numbers in the list. E.g., [a b c d] = (ab + ac + ad + bc + bd + cd)"
  [[head & tail]]
  (if (nil? tail)
    0
    (+ (sum-permutations tail) (* head (reduce + tail)))))

;; This is a less concise, but more much more space-efficient solution.
(defn sum-combinations-v2
  ([numbers]
   (sum-combinations-v2 numbers 0))
  ([numbers acc]
   (loop [[element & other] numbers acc acc]
     (if (nil? other)
       acc
       (recur numbers (* element (reduce + other)))))))


(defn squares-sum-sum-squares-diff
  "The difference between the square of the sum and the sum of the squares of a particular list
  is the sum of all permutations of two numbers in the list, which is equal to 2 times the sum
  of all combinations of two numbers in the list."
  [num]
  (* 2 (sum-permutations (take num (iterate inc 1)))))
