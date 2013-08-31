(defn fib [n]
  (loop [c n o 1 t 1]
    (if (= c 1) t
      (recur (dec c) t (+ o t))
    )))

(defn euler_2 []
(reduce + (filter (fn [n] (= 0 (mod n 2)))
(filter (fn [n] (> 4000000 n))
(map fib (range 1 40))))))
