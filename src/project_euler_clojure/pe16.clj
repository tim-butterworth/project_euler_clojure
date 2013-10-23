(defn pwr-up [n p]
  (loop [c p v 1]
    (if (> c 0)
      (recur (dec c) (* v n))
      v)))
(defn sum-num [n]
  (reduce
   +
   (map
    (fn [n] (Integer. n))
    (filter
     (fn [n] (not (= n "")))
     (clojure.string/split
      (. n toString)
      #"")))))
(defn euler_16 [n]
  ( -> (pwr-up 2N n)
       sum-num))
