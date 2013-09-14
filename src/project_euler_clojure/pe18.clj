(defn read-split-data [n]
  (reverse
   (clojure.string/split
    (slurp n)
    #"\n")))
(defn numerize-data [lst]
  (map
   (fn [n]
     (vec (map
      (fn [sn] (Integer. sn))
      (clojure.string/split
       n
       #"\s"))))
   lst))
(defn load_data [n]
  (slurp n))
(defn subVec [v start end]
  (loop [result [] i start]
    (if (< i end)
      (recur (conj result (v i)) (inc i))
      result)))
(defn merge-these [v1 v2]
  (vec
   (map
    (fn [n1 n2]
      (apply max [n1 n2]))
    v1 v2)))
(defn condense [row]
  (let [l (count row)]
    (if (> l 1)
      (merge-these (subVec row 1 l) (subVec row 0 (- l 1)))
      row)))
(defn solve [data]
  (reduce
   (fn [result n]
     (vec
      (map
       (fn [n1 n2]
         (+ n1 n2))
       (condense result)
       n)))
   data))
;(solve (-> "src/project_euler_clojure/data/sml_triangle.txt" read-split-data numerize-data))
;(solve (-> "src/project_euler_clojure/data/lrg_triangle.txt" read-split-data numerize-data))
