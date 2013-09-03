(defn combos [n]
  (loop [n1 (- n 1) n2 1 lst '()]
    (if (>= n1 n2)
      (recur (dec n1) (inc n2) (conj lst [n1 n2]))
      lst)))
(defn abc [val lst]
  (first (filter (fn [n] (= (+ (sqr (n 0)) (sqr (n 1))) (sqr val))) lst)))
(defn test [n]
  (loop [val (- n 2)]
    (def result (abc val (combos (- n val))))
    (if (and (= nil result) (> val 1))
      (recur (dec val))
      (if (= result nil)
        [0 0 0]
        (conj result val)))))

(defn euler_9 [n]
  (reduce * (test n)))
