(ns adventofcode-2016.core
  (:gen-class))


(defn -main
  "I currently just show stuff"
  [& args]
  (println "Select a level")
  (let [level (read-line)]
    (println "You selected problem #" level)))

