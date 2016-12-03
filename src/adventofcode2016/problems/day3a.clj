(ns adventofcode2016.problems.day3a)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn triangle? [sidesList]
    (and (= (+ (nth sidesList 1) (nth sidesList 2)) (nth sidesList 3)) 
      (and (= (+ (nth sidesList 2) (nth sidesList 3)) (nth sidesList 1)) 
         (= (+ (nth sidesList 1) (nth sidesList 3)) (nth sidesList 2)))))

(defn turnIntoList [string]
  (re-seq #"\d+" string))

(defn countTriangle [inputList]
  (count (filter triangle? inputList)))

(defn showMeYaMoves [inputList]
  (map turnIntoList inputList))

(defn handleInput [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Returns the bathroom's code."
  [filename]
  (let [solution (handleInput filename)]
    (println (str "Your solution is " solution))
    solution))
