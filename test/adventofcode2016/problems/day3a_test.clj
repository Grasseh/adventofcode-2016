(ns adventofcode2016.problems.day3a-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day3a :refer :all :as day3a]))

(deftest testsolve3a
  (testing "Test that it solves correctly"
    (is (= (day3a/solve "test/adventofcode2016/input/day3.txt") 1))))

