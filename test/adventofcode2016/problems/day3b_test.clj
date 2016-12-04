(ns adventofcode2016.problems.day3b-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day3b :refer :all :as day3b]))

(deftest testsolve3b
  (testing "Test that it solves correctly"
    (is (= (day3b/solve "test/adventofcode2016/input/day3.txt") 1))))

