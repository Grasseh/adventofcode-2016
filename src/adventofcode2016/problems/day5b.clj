(ns adventofcode2016.problems.day5b)
  (require 'digest)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn isValidPosition? [chr]
  (let [value (first (re-seq #"\d" chr))]
    (if (not (= value nil))
      (< (Integer. value) 8)
      false)))

(defn checkMD5 [answer startstr endint]
  (let [encrypted (re-seq #"\w" (digest/md5 (str startstr endint)))]
    (if (= (take 5 encrypted) (take 5 (repeat "0")))
      (if (isValidPosition? (nth encrypted 5))
        (let [answerList (into [] (re-seq #"[\w-]" answer))]
          (if (= (nth answerList (Integer. (nth encrypted 5))) "-")
            (let [newAnswerList (assoc answerList (Integer. (nth encrypted 5)) (nth encrypted 6))]
              (println (apply str newAnswerList))
              (apply str newAnswerList))
            answer))
        answer)
      answer)))

(defn decrypt [startstr]
  (println "--------")
  (loop [i 0 answer "--------"]
    (if (not (.contains answer "-"))
      answer
      (recur (+ i 1) (checkMD5 answer startstr i)))))

(defn showMeYaMoves [inputList]
  (decrypt (first inputList)))

(defn handleInput [filename]
  (let [lines (get-lines filename)]
    (showMeYaMoves lines)))

(defn solve
  "Get the door's password"
  [filename]
  (let [solution (handleInput filename)]
    (println (str "Your solution is " solution))
    solution))
