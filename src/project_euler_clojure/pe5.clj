(load "utils")

(defn reduce-by [lst p]
  (map (fn [n]
         (if (= (* (int (/ n p)) p) n)
           (int (/ n p))
           n)) lst ))

(defn reduce-count [lst n]
  (loop [l1 lst c 0]
    (def l2 (reduce-by l1 n))
    (if (= l1 l2)
      c
      (recur l2 (inc c)))))

(defn raise-to-power [n p]
  (loop [v 1 power p]
    (if (= power 0)
      v
      (recur (* v n) (dec power)))))

(defn product-common-divisors [lst upper]
  (reduce *
          (map (fn [n]
                 (raise-to-power n (reduce-count lst n)))
               (list-primes upper))))

(defn euler_5 [n] (product-common-divisors (range 1 (+ n 1)) n))
