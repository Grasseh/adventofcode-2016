(ns adventofcode2016.problems.day5a-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day5a :refer :all :as day5a]))

(deftest testMD5Check
  (testing "Test that MD5 encrypts correctly"
    (is (= (day5a/checkMD5 "" "abc" 3231929) "1"))))
