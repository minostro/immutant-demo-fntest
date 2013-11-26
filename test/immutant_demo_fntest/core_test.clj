(ns immutant-demo-fntest.core-test
  (:require [clojure.test :refer :all]
            [immutant-demo-fntest.core :refer :all]
            [fntest.jboss :as jboss]
            [clojure.java.io     :as io]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(defn f1 [f]
  (do
    (println "f1")
    (f)
    ))

(defn f2 [y]
  (do
    (println "f2")
    (fn [f] (do (f) (println "crazy'")))))

(use-fixtures
  :each
  (compose-fixtures f1 (f2 1)))

;(println (jboss/descriptor "file" {:root "/Users/milinostroza/Sandbox/immutant-demo-fntest"}))