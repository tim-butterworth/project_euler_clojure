(defn big-fac [n]
  (reduce
   *
   (range 1N (bigint n))))
(defn sum-digits [n]
  (reduce +
   (map (fn [n] (Integer. n))
        (filter
         (fn [n] (not (= "" n)))
         (clojure.string/split (str n) #"")))))
(defn euler_20 [n]
  (-> n
      big-fac
      sum-digits))
