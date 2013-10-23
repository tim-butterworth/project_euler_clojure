(load "utils")
(defn product-sum [n]
  (if (not (= n 0))
   (reduce + (proper-divisors n))
   0))
(defn find-amicables [lst]
  (filter
   (fn [n] (and (not (= n (product-sum n))) (= n (product-sum (product-sum n)))))
   lst))
(defn euler_21 [n]
  (reduce + (find-amicables (range 1 n))))
