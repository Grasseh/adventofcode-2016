(ns adventofcode2016.problems.day2b-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day2b :refer :all :as day2b]))

(deftest testsolve2b
  (testing "Test that it solves correctly"
    (is (= (day2b/solve "test/adventofcode2016/input/day2_a.txt") "5DB3"))))

