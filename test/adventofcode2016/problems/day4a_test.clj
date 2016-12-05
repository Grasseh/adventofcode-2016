(ns adventofcode2016.problems.day4a-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day4a :refer :all :as day4a]))

(deftest testsolve4a
  (testing "Test that it solves correctly"
    (is (= (day4a/solve "test/adventofcode2016/input/day4.txt") 1514))))
