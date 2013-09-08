(ns project-euler-clojure.core-test
  (:require [clojure.test :refer :all]
            [project-euler-clojure.core :refer :all]))

(deftest fib-test
  (testing "testing fib"
    (is (= (fib 4) 5))
    )
)
(deftest mag-test
  (testing "seeing if the correct magnitude is returned"
    (is (= (mag 1000) 3))
    )
)
(deftest is-palendrome-1
  (testing "testing if is-palendrome positively identifies palendromes"
    (is (= (map (fn [n] (is-palendrome n)) '(1 11 101 212 21 111 97))
           '(true true true true false true false)))
    )
)
(deftest palendrome-test-1
  (testing "testing find-first-palendrome"
    (is (= (find-first-palendrome 999 1) 90909))
      )
)
(deftest palendrome-test-2
  (testing "testing find-max-palendrome"
    (is (= (find-max-palendrome 199 1)
           36863)
        )
    )
)
;(deftest )
(deftest abs-test-1
  (testing "testing abs gives positive value for negative number"
    (is (= (abs -1) 1))))
(deftest abs-test-2
  (testing "testing abs gives positive value for a positive number"
    (is (= (abs 1) 1))))

(deftest interpolate-test-1
  (testing "testing abs gives positive value for a positive number"
    (is (= (interpolate [0 0] [0 0]) (list [0 0])))))

(deftest interpolate-test-2
  (testing "testing abs gives positive value for a positive number"
    (def inter-list (interpolate [10 0] [2 8]))
    (is (= inter-list '([10 0] [9 1] [8 2] [7 3] [6 4] [5 5] [4 6] [3 7] [2 8])))))
