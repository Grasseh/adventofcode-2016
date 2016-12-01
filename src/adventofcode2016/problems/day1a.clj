(ns adventofcode2016.problems.day1a)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn distance [coords]
  (+ (Math/abs (get coords :x)) (Math/abs (get coords :y))))

(defn move [coords direction distance]
  (let [dist (Integer. (re-find #"\d+" distance))]
    (case direction
      "N" {:x (get coords :x), :y (+ (get coords :y) dist)}
      "E" {:x (+ (get coords :x) dist), :y (get coords :y)}
      "S" {:x (get coords :x), :y (- (get coords :y) dist)}
      "W" {:x (- (get coords :x) dist), :y (get coords :y)})))

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
          "W" "S")))

(defn showMeYaMoves [moveList]
  (distance (loop [pos {:x 0, :y 0} dir "N" mL moveList]
    (if (empty? mL)
      pos
      (let [newDir (changeDir dir (first (re-seq #"\w" (first mL))))]
      (recur (move pos newDir (first mL)) newDir (drop 1 mL)))))))

(defn doStuff [filename]
  (let [lines (get-lines filename)]
  (let [data (nth lines 0)] (showMeYaMoves (re-seq #"\w\d+" data)))))

(defn solve
  "Return the distance from the starting point"
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
