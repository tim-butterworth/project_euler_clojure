(load "utils")
(defn no-divisor [x lst]
  (def test-root (recur-sqrt x))
  (def root (if (= test-root 1)
              x
              test-root))
  (= () (filter
         (fn [e] (if (< e root)
                   (= 0 (mod x e))
                   false))
         lst)))
                                        ;test is n has any divisors (is n prime) if yes, append n to the list
(defn add-if-prime [n lst]
  (def rt ())
  (if (no-divisor n lst)
    (conj lst n)
    lst))
                                        ;lists the primes less than n
(defn list-n-primes [n]
  (loop [c 3 lst [2]]
    (if (<= n 1)
      []
      (if (= (count lst) n)
        lst
        (recur (inc c) (add-if-prime c lst))))))
(defn euler_7 [n] (apply max (list-n-primes n)))
