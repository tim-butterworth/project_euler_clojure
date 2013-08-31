(defn sum-sqr [n]
  (reduce + (map (fn [n] (* n n)) (range 1 (+ n 1)))))

(defn sqr-sum [n]
  (def summed (reduce + (range 1 (+ n 1))))
  (* summed summed))

(defn euler_6 [n] (- (sqr-sum n) (sum-sqr n)))
