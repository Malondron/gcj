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
        (do
          (print sum)
        (recur (+ sum (* (Math/pow base (- num-length (+ base 1))) (.indexOf source-lang (str (nth number i))))) (inc i)) )))))

(defn translate-number [number source-lang target-lang]
  (let [num-len (count number)
        base (count source-lang)
        new-base (count target-lang)
        value-to-translate (to-base-ten number source-lang base)
        largest-exponent (Math/floor (/ (Math/log value-to-translate) (Math/log new-base)))]
    value-to-translate))

(defn alien-numbers []
  (let [lines (read-lines "c:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.in")
        nCases (read-string (first lines))]
   (doseq [l [(second lines)]]
     (let[l-parse (split l #" ")
          out (translate-number (first l-parse) (second l-parse) (nth l-parse 2))]
       (print out)))))
;       (write-lines "c:\\gcj\\2008Practise\\PracticeProblems\\A-small-practice.out.clj" out)))))

(alien-numbers)
(.indexOf "hej" (str(second "he")))