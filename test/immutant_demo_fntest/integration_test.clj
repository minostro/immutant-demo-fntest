; (ns immutant-demo.integration-test
;       (:use clojure.test)
;       (:require [clj-http.client :as http]
;                 [fntest.core     :as fntest]))

; (use-fixtures :once
;   (compose-fixtures
;     fnt/with-jboss
;     (fnt/with-deployment *file* {:root "./", :context-path "/foo"})))

; ;;; Run browser tests against the deployed app
; (deftest remote-http-test
;   (let [result (http/get "http://localhost:8080/foo")]
;     (is (.contains (:body result) "Howdy!"))))

; ;;; Alternatively, deploy and run all tests in one shot
; (deftest run-all-tests-inside-immutant
;   (is (fntest/test-in-container "some-name" "./")))


(ns immutant-demo-fntest.integration-test
      (:use clojure.test)
      (:require [clj-http.client :as http]
                [fntest.core     :as fnt]))

(use-fixtures :once
      (compose-fixtures
        fnt/with-jboss
        (fnt/with-deployment "immutant-demo-fntest.clj" {:root "/Users/milinostroza/Sandbox/immutant-demo-fntest/", :context-path "/foo"})))

(deftest first-integration-test
  (testing "jbos"
    (is (= 1 1))))