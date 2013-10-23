(load "utils")
(defn product-sum [n]
  (if (not (= n 0))
   (reduce + (proper-divisors n))
   0))
