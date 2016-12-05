(defproject adventofcode-2016 "0.0.1"
  :description "Advent of Code solutions"
  :url "http://www.github.com/grasseh/adventofcode-2016"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"], [digest "1.4.5"]]
  :main ^:skip-aot adventofcode2016.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
