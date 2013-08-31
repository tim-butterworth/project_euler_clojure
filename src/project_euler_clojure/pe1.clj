(defn getModSet [a b] (set (filter (fn[n] (= (mod n a) 0)) (range b))))

(defn euler_1 []
  (reduce +
    (clojure.set/union (getModSet 3 1000) (getModSet 5 1000))
  ))
