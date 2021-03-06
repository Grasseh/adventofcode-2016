(ns adventofcode2016.core
  (:gen-class) 
  (:require [adventofcode2016.problems.day0a :as day0a])
  (:require [adventofcode2016.problems.day1a :as day1a])
  (:require [adventofcode2016.problems.day1b :as day1b])
  (:require [adventofcode2016.problems.day2a :as day2a])
  (:require [adventofcode2016.problems.day2b :as day2b])
  (:require [adventofcode2016.problems.day3a :as day3a])
  (:require [adventofcode2016.problems.day3b :as day3b])
  (:require [adventofcode2016.problems.day4a :as day4a])
  (:require [adventofcode2016.problems.day4b :as day4b])
  (:require [adventofcode2016.problems.day5a :as day5a])
  (:require [adventofcode2016.problems.day5b :as day5b])
  )

(defn call [nspace nm & args]
  (if-let [func (resolve (symbol nspace nm))] 
    (apply func args)
    (println "No problem found.")))

(defn -main
  "I currently just show stuff"
  [& args]
  (println "Select a level")
  (let [level (read-line)]
    (println "You selected problem #" level)
    (call (str "adventofcode2016.problems.day" level) "solve" (str "input/day" level ".txt"))))


