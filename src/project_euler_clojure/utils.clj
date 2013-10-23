(defn sqr [n]
  (* n n))

(defn mag [n]
  (loop [num n c 0]
    (if (> 10 num) c
        (recur (/ num 10) (+ c 1)))))

(defn down-mag [n c]
  (loop [num n cnt c]
    (if (<= cnt 0) num
        (recur (/ num 10) (dec cnt)))))
(defn first-guess [n]
 (double (down-mag n (int (/ (mag n) 2)))))
;not a very sophisticated test of primeality
(defn no-divisor [x lst]
  (= () (filter
         (fn [e] (= 0 (mod x e)))
         lst)))

(defn nextguess [n g] (double (/ (+ (/ n g) g) 2)))

(defn ceil [n]
  (if (= (double (int n)) n)
    (int n)
    (+ (int n) 1)))

(defn recur-sqrt [n]
  (loop [num n gn (first-guess n)]
   (if (and (< (sqr (- gn 1)) num) (>= (sqr gn) num))
       (ceil gn)
      (recur num (nextguess num gn)))))
;not a very sophisticated test of primeality
(defn no-divisor [x lst]
  (def rt (recur-sqrt x))
  (= () (filter
         (fn [e] (and (> rt e) (= 0 (mod x e))))
         lst)))

;test is n has any divisors (is n prime) if yes, append n to the list
(defn add-if-prime [n lst]
  (if (no-divisor n lst)
    (conj lst n)
    lst))
;lists the primes less than n
(defn list-primes [n]
  (loop [c 3 lst [2]]
    (if (<= n 2)
      []
    (if (> c n)
      lst
      (recur (inc c) (add-if-prime c lst))))))

(defn abs [n]
  (if (> 0 n)
    (* -1 n)
    n))
;lists the primes less than n
(defn list-n-primes [n]
  (loop [c 3 lst [2]]
    (if (<= n 1)
      []
      (if (= (count lst) n)
        lst
        (recur (inc c) (add-if-prime c lst))))))
(defn options [n]
  (range 1 (+ (recur-sqrt n) 1)))
(defn find-divisors [n lst]
  (filter
   (fn [v]
     (= (mod n v) 0))
   lst))
(defn proper-divisors [n]
  (let [small (find-divisors n (options n))]
    (clojure.set/difference
     (clojure.set/union
      (set small)
      (set
       (map
        (fn [v] (/ n v))
        small)))
     #{n})))
