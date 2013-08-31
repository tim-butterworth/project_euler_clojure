(load "utils")

(defn is-prime [n]
  (no-divisor n (range 2 (recur-sqrt n))))

(defn prime-divisors [n]
  (def lst
    (filter (fn [entry] (= 0 (mod n entry)))
            (range 1 (recur-sqrt n))))
  (filter (fn [val] (is-prime val)) (clojure.set/union
                              (set (map (fn [val] (/ n val)) lst))
                              (set lst))))
(defn euler_3 [n]
  (str (apply max (prime-divisors n))))
