(ns adventofcode2016.problems.day4a)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn groupList [lst]
  (group-by (fn [a] a) lst))

(defn getCharList [input]
  (sort (drop-last 5 (re-seq #"[a-z]" input))))

(defn count-second [lst]
  (count (second lst)))

(defn getRoomCode [input]
  (let [charList (getCharList input)]
    (let [groupedList (sort (groupList charList))]
      (let [fullyOrderedList (sort-by count-second > groupedList)]
        (let [FiveOnlyList (take 5 fullyOrderedList)]
          (let [roomString (apply str (map first FiveOnlyList))]
            roomString))))))

(defn checkSum [input]
  (let [cs (nth (re-find #"\[(\w+)\]" input) 1)]
    (let [sector (Integer. (re-find #"\d+" input))]
      (if (= (getRoomCode input) cs)
        sector
        0))))

(defn checkSums [inputList]
  (map checkSum inputList))

(defn showMeYaMoves [inputList]
  (reduce + (checkSums inputList)))

(defn handleInput [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Get the sum of the sector IDs of real rooms"
  [filename]
  (let [solution (handleInput filename)]
    (println (str "Your solution is " solution))
    solution))
