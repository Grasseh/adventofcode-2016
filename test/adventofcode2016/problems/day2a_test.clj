(ns adventofcode2016.problems.day2a-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day2a :refer :all :as day2a]))

(deftest testsolve2a
  (testing "Test that it solves correctly"
    (is (= (day2a/solve "test/adventofcode2016/input/day2_a.txt") "1985"))))

