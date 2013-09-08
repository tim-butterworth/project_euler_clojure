(defn triangle [n]
  (reduce + (range (+ n 1))))
(defn small-factors [n]
  (filter
   (fn [d] (= 0 (mod n d)))
   (range 1 (+ (recur-sqrt n) 1))))
(defn add-compliment-factors [n small-factor-list]
  (clojure.set/union
   (set (map (fn [factor] (/ n factor))
             small-factor-list))
   (set small-factor-list)))
(defn all-factors [n]
  (add-compliment-factors n (small-factors n)))
(defn first-n-factor-triangle [n]
  (loop [tri 1]
    (if (>= (count (all-factors
                    (triangle tri))) n)
      (triangle tri)
      (recur (inc tri)))))
