(ns adventofcode2016.problems.day2a)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn move [coords direction]
    (case (str direction)
      "U" (if (< coords 4) 
            coords 
            (- coords 3))
      "R" (if (= (mod coords 3) 0) 
            coords 
            (+ coords 1))
      "D" (if (> coords 6) 
            coords 
            (+ coords 3))
      "L" (if (= (mod coords 3) 1) 
            coords 
            (- coords 1))
      coords))

(defn handleOneRow [row pos]
  (let [moveList (re-seq #"\w" row)]
  (loop [p pos mL moveList]
    (if (empty? mL)
      p
      (let [newPos (move p (first mL))]
        (recur newPos (drop 1 mL)))))))

(defn showMeYaMoves [moveList]
  (loop [pos 5  mL moveList answer ""]
    (if (empty? mL)
      answer
      (let [newAnswer (handleOneRow (first mL) pos)]
        (recur newAnswer (drop 1 mL) (str answer newAnswer))))))

(defn doStuff [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Returns the bathroom's code."
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
