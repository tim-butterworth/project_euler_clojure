(defn Collatz-count [n]
  (loop [count 1 num n]
    (if (= 1 num) count
        (recur (inc count)
               (if (= 0 (mod num 2))
                 (/ num 2)
                 (+ 1 (* 3 num)))))))
(defn euler_14 [num]
  (reduce
   (fn [result n]
     (if (> (result 1) (n 1))
       result
       n))
   (map (fn [n]
          [n (Collatz-count n)])
        (range 1 num))))
