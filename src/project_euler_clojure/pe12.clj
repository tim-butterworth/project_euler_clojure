(defn triangle [n]
  (reduce + (range (+ n 1))))
(defn small-factors [n]
  (filter
   (fn [d] (= 0 (mod n d)))
   (range 1 (+ (recur-sqrt n) 1))))
(defn add-compliment-factors [n small-factor-list]
  (clojure.set/union
   (set (pmap (fn [factor] (/ n factor))
             small-factor-list))
   (set small-factor-list)))
(defn all-factors [n]
  (add-compliment-factors n (small-factors n)))
(defn first-n-factor-triangle [n]
  (loop [tri 1]
    (let [triangled (triangle tri)]
      (if (>= (count (all-factors triangled)) n)
        triangled
        (recur (inc tri))))))
(defn first-n-factor-triangle-opt [n]
  (loop [tri 1]
    (let [triangled (triangle tri)]
      (if (>= (recur-sqrt triangled) (/ n 2))
        (if (>= (count (all-factors triangled)) n)
          triangled
          (recur (inc tri)))
        (recur (inc tri))))))
