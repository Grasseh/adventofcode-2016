(ns adventofcode2016.problems.day2b)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn move [coords direction]
    (case coords
      "1" (case direction 
            "D" "3"
            coords)
      "2" (case direction 
            "R" "3"
            "D" "6"
            coords)
      "3" (case direction 
            "U" "1"
            "L" "2"
            "R" "4"
            "D" "7"
            coords)
      "4" (case direction 
            "L" "3"
            "D" "8"
            coords)
      "5" (case direction 
            "R" "6"
            coords)
      "6" (case direction 
            "U" "2"
            "L" "5"
            "R" "7"
            "D" "A"
            coords)
      "7" (case direction 
            "U" "3"
            "L" "6"
            "R" "8"
            "D" "B"
            coords)
      "8" (case direction 
            "U" "4"
            "L" "7"
            "R" "9"
            "D" "C"
            coords)
      "9" (case direction 
            "L" "8"
            coords)
      "A" (case direction 
            "U" "6"
            "R" "B"
            coords)
      "B" (case direction 
            "U" "7"
            "L" "A"
            "R" "C"
            "D" "D"
            coords)
      "C" (case direction 
            "U" "8"
            "L" "B"
            coords)
      "D" (case direction 
            "U" "B"
            coords)
      ))

(defn handleOneRow [row pos]
  (let [moveList (re-seq #"\w" row)]
  (loop [p pos mL moveList]
    (if (empty? mL)
      p
      (let [newPos (move p (first mL))]
        (recur newPos (drop 1 mL)))))))

(defn showMeYaMoves [moveList]
  (loop [pos "5"  mL moveList answer ""]
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
