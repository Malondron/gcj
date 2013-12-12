(ns alienNumbers
  (:use [clojure.java.io :only [reader writer]]
        [clojure.string :only [split]])
  (:import (java.io File)))

(Math/pow 2 3)

(defn read-lines [file]
  (with-open [r (reader file)]
    (doall (line-seq r))))

(defn write-lines [file s]
  (with-open [w (writer file)]
    (doseq [line s]
      (.write w line))))


(defn to-base-ten [number source-lang base]
  (let [num-length (count number)]
    (loop [sum 0 i 0]
      (if (= i num-length)
        sum
        (recur (+ sum (* (Math/pow base (- num-length (+ base 1))) (.indexOf source-lang (nth number i)))) (inc i)) ))))


(defn translate-number [number source-lang target-lang]
  (let [num-len (count number)
        base (count source-lang)
        new-base (count target-lang)
        value-to-translate (to-base-ten number source-lang)
        largest-exponent (Math/floor (/ (Math/log value-to-translate) (Math/log new-base)))]
    largest-exponent))

(defn alien-numbers []
  (let [lines (read-lines "c:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.in")
        nCases (read-string (first lines))]
   (doseq [l (rest lines)]
     (let[l-parse (split l #" ")
          out (translate-number l-parse)]
       (write-lines "c:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.out.clj" out)))))

(alien-numbers)