(ns adventofcode2016.problems.day1a-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day1a :refer :all :as day1a]))

(deftest testsolvea
  (testing "Test that it solves correctly"
    (is (= (day1a/solve "test/adventofcode2016/input/day1_a.txt") 5))))

(deftest testsolveb
  (testing "Test that it solves correctly"
    (is (= (day1a/solve "test/adventofcode2016/input/day1_b.txt") 2))))

(deftest testsolvec
  (testing "Test that it solves correctly"
    (is (= (day1a/solve "test/adventofcode2016/input/day1_c.txt") 12))))
