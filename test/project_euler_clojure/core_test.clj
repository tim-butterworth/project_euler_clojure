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
