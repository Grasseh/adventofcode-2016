(ns adventofcode2016.problems.day4b-test
  (:require [clojure.test :refer :all]
            [adventofcode2016.problems.day4b :refer :all :as day4b]))

(deftest testsolve4b
  (testing "Test that it solves correctly"
    (is (= (apply str (day4b/decrypt "qzmt-zixmtkozy-ivhz-343")) "very-encrypted-name-343"))))
