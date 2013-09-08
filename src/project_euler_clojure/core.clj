(ns project-euler-clojure.core
  (:gen-class))
(require 'clojure.set)
(require 'clojure.string)
(load "pe1")
(load "pe2")
(load "pe3")
(load "pe4")
(load "pe5")
(load "pe6")
(load "pe7")
(load "pe8")
(load "pe9")
(load "pe10")
(load "pe11")

(defn jn [lst] (str "Problem " (clojure.string/join ": " lst)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!")
  (println (jn ["1" (euler_1)]))
  (println (jn ["2" (euler_2)]))
  (println (jn ["3" (euler_3 600851475143)]))
  (println (jn ["4" (euler_4 999)]))
  (println (jn ["5" (euler_5 20)]))
  (println (jn ["6" (euler_6 100)]))
  (println (jn ["7" (euler_7 10001)]))
  (println (jn ["8" (euler_8 5)]))
  (println (jn ["9" (euler_9 1000)]))
  (println "2,000,000 is too large for quick calculation... takes maybe 20-30 seconds, so we will do only 10,000")
  (println (jn ["10" (euler_10 10000)]))
  (println (jn ["11" (euler_11 "src/project_euler_clojure/data/pe11.txt")]))
)
