(load "utils")

(defn sum-primes [n]
  (reduce + (list-primes n)))

(defn required-primes [n] (list-primes (recur-sqrt n)))

(defn filter-multiples [d lst]
  (filter
   (fn [n]
     (or (<= n d) (not (= 0 (mod n d)))))
   lst))

(defn prime-seive [n]
  (reduce
   (fn [lst prime] (filter-multiples prime lst))
   (range 2 n)
   (required-primes n)))

(defn euler_10 [n]
  (reduce + (prime-seive n)))
