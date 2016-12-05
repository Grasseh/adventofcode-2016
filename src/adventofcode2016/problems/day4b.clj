(ns adventofcode2016.problems.day4b)
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

(defn move [chr amt]
  (let [realAmt (- amt (* 26 (quot amt 26)))]
    (let [valChr (int (.charAt chr 0))]
      (if (> valChr 122)
        chr
        (if (< valChr 97)
        chr   
        (if (> (+ realAmt valChr) 122)
          (str (char (- valChr (- 26 realAmt))))
          (str (char (+ valChr realAmt)))))))))

(defn decrypt [input]
  (let [sector (Integer. (re-find #"\d+" input))]
    (map move (re-seq #"[\w-]" input) (repeat sector))
  ))

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

(defn isValid? [input]
  (not (= 0 checkSum input)))

(defn getValidInputs [inputList]
  (filter isValid? inputList))

(defn cleanUp [lst]
  (print (map #(apply str %) lst)))

(defn showMeYaMoves [inputList]
  (cleanUp (map decrypt (getValidInputs inputList))))

(defn handleInput [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Get the sum of the sector IDs of real rooms"
  [filename]
  (let [solution (handleInput filename)]
    (println (str "Your solution is " solution))
    solution))
