(ns eggDrop
  (:use [clojure.java.io  :only [reader writer]]
        [clojure.string  :only [split]])
  (:import (java.io File)))

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

(defn egg-drop []
   (let [lines (read-lines infile)
          nCases (read-string (first lines))
          out-file outfile]