(ns adventofcode2016.problems.day5a)
  (require 'digest)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn checkMD5 [answer startstr endint]
  (let [encrypted (re-seq #"\w" (digest/md5 (str startstr endint)))]
    (if (= (take 5 encrypted) (take 5 (repeat "0")))
      (str answer (nth encrypted 5))
      answer))) 

(defn decrypt [startstr]
  (loop [i 0 answer ""]
    (if (= (count answer) 8)
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
