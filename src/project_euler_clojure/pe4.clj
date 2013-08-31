(defn sb [n val]
  (subs val n (+ n 1)))
;Eric gave me this much more elegant solution
(defn is-palendrome [n]
  (def nstr (str n))
  (= (reverse nstr) (reverse (reverse nstr))))

;Original solution, works, but is not elegant
(defn recur-is-palendrome [n]
  (def nstr (str n))
  (def l (- (count nstr) 1))
  (loop [p l match true]
    (if (<= p (- l p))
      match
      (if (not match)
          match
          (recur (dec p) (= (sb (- l p) nstr) (sb p nstr)))
        ))))
(defn search-list [lst c]
  (loop [p lst]
    (if (= p ())
      ()
      (if (is-palendrome (* (first p) c))
        [(first p) c (* c (first p))]
        (recur (rest p))
        ))))
(defn find-first-palendrome [t b]
  (loop [p t]
    (if (is-palendrome (* t p))
      (* t p)
      (if (< b p)
        (recur (dec p))
        0
      ))))
(defn find-max-palendrome [t b]
  (loop [f t l b guess b]
    (if (< l f)
      (recur (dec f)
             (int (/ guess f))
             (max guess (find-first-palendrome f (int (/ guess f)))))
      guess
      )))

(defn euler_4 [n]
  (find-max-palendrome n (int (/ n 10))))
