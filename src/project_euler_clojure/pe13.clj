(defn subString [str num]
  (. str subSequence 0 num))
(defn toString [bigint]
  (. bigint toString))
(defn sum_bigIntegers [lst]
  (reduce
   +
   lst))
(defn to_bigInteger [lst]
  (map
   (fn [n]
     (new BigInteger n))
   lst))
(defn load_clean [str]
   (clojure.string/split
    (slurp str)
    #"\s"))
(defn euler_13 [data num]
  (->
   data
   load_clean
   to_bigInteger
   sum_bigIntegers
   toString
   (subString num)
   ))
