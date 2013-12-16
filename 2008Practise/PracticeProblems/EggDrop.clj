(ns eggDrop
  (:use [clojure.java.io  :only [reader writer]]
        [clojure.string  :only [split]])
  (:import (java.io File)))

(def d-max 30000)
(def b-max 33)
(def infile "c:\\gcj\\2008Practise\\PracticeProblems\\C-small-practice.in")
(def outfile "c:\\gcj\\2008Practise\\PracticeProblems\\C-small-practice.out.clj")
;(def infile "/home/andreask/gcj/2008Practise/PracticeProblems/C-small-practice.in")
;(def outfile "/home/andreask/gcj/2008Practise/PracticeProblems/C-small-practice.out.clj")


(defn read-lines [file]
  (with-open [r (reader file)]
    (doall (line-seq r))))

(defn write-lines
	  "Writes lines (a seq) to f, separated by newlines.  f is opened with
	  writer, and automatically closed at the end of the sequence."
	  [f lines]
	  (with-open [writer (writer f)]
	    (loop [lines lines]
	      (when-let [line (first lines)]
	        (.write writer (str line))
	        (.newLine writer)
	        (recur (rest lines))))))


(defn cals-new-term [d b F]
   (if (or (= d 0) (= b 0))
     0
    (if (= d 1)
      1
      (+ 1 (F (str [(- d 1) b]) (F (str [(- d 1) (- b 1)])))))))


(defn set-up-f [F]
  (loop [x 0 out F]
    (if (= x d-max)
      F
      (let [y-calcs (loop [y 0 out2 out]
                      (if (= b-max y)
                        out2
                        (recur (inc y) (calc-new-term x y out2))))]
        (recur (inc x) y-calcs)))))

(defn egg-drop []
   (let [lines (read-lines infile)
         nCases (read-string (first lines))
         F (set-up-f {})
         out-file outfile]
     F))

(let [F {(str [1 0]) 1}]
  (F (str [1 0])))
