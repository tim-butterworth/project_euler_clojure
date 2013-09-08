(defn split [n regex]
  (clojure.string/split n regex))
(defn get-data-arrays [n]
  (vec
   (map
    (fn [n] (vec (map
             (fn [n] (Integer. n))
             (split n #"\s"))))
    (split (slurp n) #"\n"))))
(defn get-data [data x y]
  ((data y) x))
(defn max-horizontal [data]
  (apply max (map
              (fn [n]
               (if (= (count n) 4)
                 (reduce * n)
                 0))
              (reduce
               (fn [result n] (concat result n))
               (map
                (fn [n] (partition 4 1 n))
                data)))))
(defn re-map [d transformation]
  (map
   (fn [row]
     (map
      (fn [point]
        (get-data d (point 0) (point 1)))
      row))
   transformation))
(defn get-difference [p1 p2 n]
   (- (p2 n) (p1 n)))
(defn factor [p1 p2 n]
  (if (= (get-difference p1 p2 n) 0)
    0
    (/ (get-difference p1 p2 n) (abs (get-difference p1 p2 n)))))
(defn straight-distance [p1 p2 n]
  (abs (- (p1 n) (p2 n))))
(defn get-widths [p1 p2]
  [(straight-distance p1 p2 0)
   (straight-distance p1 p2 1)])
(defn get-width [p1 p2]
 (+ (apply max (get-widths p1 p2)) 1))
(defn get-interpolation-point [p1 p2 xy step]
  (+ (p1 xy) (* (factor p1 p2 xy) step)))
(defn interpolate [p1 p2]
  (map (fn [n] [(get-interpolation-point p1 p2 0 n)
                (get-interpolation-point p1 p2 1 n)])
       (range (get-width p1 p2))))
(defn inter-merge [lists]
  (map
   (fn [n] (interpolate (n 0) (n 1)))
   (map
    (fn [n1 n2] [n1 n2])
        (lists 0)
        (lists 1))))
(defn bounds-to-points [points]
   [(interpolate ((points 0) 0) ((points 0) 1))
   (interpolate ((points 1) 0) ((points 1) 1))])
(defn bounds-to-points-adapter [data points-fun]
  (def n (- (count data) 1))
  (bounds-to-points n (points-fun n)))

(defn dimension [] (fn [data]  (- (count data) 1)))

(defn vertical [] (fn [n] [[[0 0][n 0]][[0 n][n n]]]))
(defn horizontal [] (fn [n] [[[0 0][0 n]][[n 0][n n]]]))
(defn diag1-t [] (fn [n] [[[0 0][n 0]][[0 0][0 n]]]))
(defn diag1-b [] (fn [n] [[[1 n][n n]][[n 1][n n]]]))
(defn diag2-b [] (fn [n] [[[0 n][0 0]][[0 n][n n]]]))
(defn diag2-t [] (fn [n] [[[1 0][n 0]][[n (- n 1)][n 0]]]))

(defn thread-together [f data]
  (max-horizontal
   (re-map data
           (inter-merge
            (bounds-to-points
             ((f)
              ((dimension)
               data)))))))

(defn euler_11 [n]
;n = "src/project_euler_clojure/data/pe11.txt"
  (apply max (map (fn [f] (thread-together f (get-data-arrays n)))
  [vertical horizontal diag1-t diag1-b diag2-t diag2-b])))
