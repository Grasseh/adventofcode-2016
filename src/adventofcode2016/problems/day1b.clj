(ns adventofcode2016.problems.day1b)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn distance [coords]
  (+ (Math/abs (get coords :x)) (Math/abs (get coords :y))))

(defn move [coords direction distance]
  (case direction
    "N" {:x (get coords :x), :y (+ (get coords :y) 1)}
    "E" {:x (+ (get coords :x) 1), :y (get coords :y)}
    "S" {:x (get coords :x), :y (- (get coords :y) 1)}
    "W" {:x (- (get coords :x) 1), :y (get coords :y)}))

(defn changeDir [direction turn]
  (case turn 
    "R" (case direction
          "N" "E"
          "E" "S"
          "S" "W"
          "W" "N")
    "L" (case direction
          "N" "W"
          "E" "N"
          "S" "E"
          "W" "S")
    direction ))

(defn lower [distance]
  (let [dir (re-find #"\w" distance)]
    (let [dist (Integer. (re-find #"\d+" distance))]
      (if (= dist 1)
        nil
        (str "-" (- dist 1))))))

(defn arrangeMoves [mL]
  (if (= (lower (first mL)) nil)
    (drop 1 mL)
    (conj (drop 1 mL) (lower (first mL)))))

(defn passedAlready? [passedPos pos]
  (loop [pP passedPos p pos]
    (if(empty? pP)
      false
      (if (and (= (get p :x) (get (first pP) :x)) (= (get p :y) (get (first pP) :y)))
        true
        (recur (drop 1 pP) p)))))

(defn showMeYaMoves [moveList]
  (distance (loop [pos {:x 0, :y 0} dir "N" mL moveList passedPos [{:x 9999, :y 9999}]]
    (if (passedAlready? passedPos pos)
      pos
      (let [newDir (changeDir dir (first (re-seq #"\w" (first mL))))]
        (recur (move pos newDir (first mL)) newDir (arrangeMoves mL) (conj passedPos pos)))))))

(defn doStuff [filename]
  (let [lines (get-lines filename)]
  (let [data (nth lines 0)] (showMeYaMoves (re-seq #"\w\d+" data)))))

(defn solve
  "Return the distance from the starting point"
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
