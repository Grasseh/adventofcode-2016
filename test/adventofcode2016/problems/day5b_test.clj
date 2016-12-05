(ns adventofcode2016.problems.day5b-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day5b :refer :all :as day5b]))

;;(deftest testsolve5b
;;  (testing "Test that it solves correctly"
;;    (is (= (day5b/solve "test/adventofcode2016/input/day5.txt") "05ace8e3"))))

(deftest testMD5Check
  (testing "Test that MD5 encrypts correctly"
    (is (= (day5b/checkMD5 "--------" "abc" 3231929) "-5------"))))
