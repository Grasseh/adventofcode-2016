(ns adventofcode2016.problems.day1b-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day1b :refer :all :as day1b]))

(deftest testsolve1b
  (testing "Test that it solves correctly"
    (is (= (day1b/solve "test/adventofcode2016/input/day1_d.txt") 4))))

