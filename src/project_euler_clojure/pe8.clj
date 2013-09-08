(defn string-to-number [n]
  ({"0" 0
    "1" 1
    "2" 2
    "3" 3
    "4" 4
    "5" 5
    "6" 6
    "7" 7
    "8" 8
    "9" 9} n))
(defn to-number-vec [lst]
  (vec (filter (fn [n] (not (= n nil))) (map (fn [n] (string-to-number n)) lst))))
(defn get-number-vector [n]
  (to-number-vec (clojure.string/split (slurp n) #"")))
(def base-vec (get-number-vector "src/project_euler_clojure/data/pe8.txt"))
(defn get-subset [lst size offset]
  (subvec lst
          (- size offset)
          (- (count lst) offset)))
(defn get-subsets [lst size]
  (loop [result '() offset 0]
    (if (< offset size)
     (recur (conj result (get-subset lst size offset)) (inc offset))
     result)))
(defn sub-shift [n offset lst]
  (subvec lst offset (- (count lst) (- n offset))))
(defn euler_8 [n]
  (apply max
         (reduce (fn [l1 l2]
                   (map * l1 l2))
                 (get-subsets base-vec n))))
