(ns immutant-demo.integration-test
      (:use clojure.test)
      (:require [clj-http.client :as http]
                [fntest.core     :as fntest]))

;;; Fire up Immutant
(use-fixtures :once fntest/with-jboss)

;;; Deploy our application
(use-fixtures :once (fntest/with-deployment *file* {:root "./", :context-path "/foo"}))

;;; Run browser tests against the deployed app
(deftest remote-http-test
  (let [result (http/get "http://localhost:8080/foo")]
    (is (.contains (:body result) "Howdy!"))))

;;; Alternatively, deploy and run all tests in one shot
(deftest run-all-tests-inside-immutant
  (is (fntest/test-in-container "some-name" "./")))