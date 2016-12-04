(ns adventofcode2016.problems.day3b)
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn triangle? [sidesList]
  (and (> (+ (nth sidesList 1) (nth sidesList 2)) (nth sidesList 0)) 
    (and (> (+ (nth sidesList 2) (nth sidesList 0)) (nth sidesList 1)) 
       (> (+ (nth sidesList 1) (nth sidesList 0)) (nth sidesList 2)))))

(defn intThis [string]
  (Integer. string))

(defn turnIntoList [string]
  (map intThis (re-seq #"\d+" string)))

(defn filterList [inputList i]
  (list 
    (nth inputList (- (+ i (* 6 (quot (- i 1) 3))) 1))
    (nth inputList (- (+ 3 (+ i (* 6 (quot (- i 1) 3)))) 1))
    (nth inputList (- (+ 6 (+ i (* 6 (quot (- i 1) 3)))) 1))
    ))

(defn countTriangle [inputList]
  (loop [i 1 amount 0 max (/ (count inputList) 3)]
    (if (< max i)
      amount 
      (recur (+ i 1) (if(triangle? (filterList inputList i)) (+ amount 1) amount) max))))

(defn showMeYaMoves [inputList]
  (countTriangle (flatten (map turnIntoList inputList))))

(defn handleInput [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Count the number of possible triangles."
  [filename]
  (let [solution (handleInput filename)]
    (println (str "Your solution is " solution))
    solution))
