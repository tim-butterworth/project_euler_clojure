(defn small-list [n]
  (range 1 (+ (/ n 2) 1)))
(defn large-list [n]
  (range (+ (/ n 2) 1) (+ n 1)))
(defn euler_15 [n]
  (reduce
   *
   (map
    (fn [n1 n2] (/ n2 n1))
    (small-list n)
    (large-list n))))
