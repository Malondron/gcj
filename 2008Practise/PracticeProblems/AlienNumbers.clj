(ns alienNumbers
  (:use [clojure.java.io :only [reader writer]]
        [clojure.string :only [split]])
  (:import (java.io File)))

(def infile "/home/andreask/gcj/2008Practise/PracticeProblems/A-large-practice.in")
(def outfile "/home/andreask/gcj/2008Practise/PracticeProblems/A-large-practice.out.clj")

(defn read-lines [file]
  (with-open [r (reader file)]
    (doall (line-seq r))))

(defn write-lines [file s]
  (with-open [w (writer file)]
    (doseq [line s]
      (.write w line))))

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


(defn to-base-ten [number source-lang base]
  (let [num-length (count number)]
    (loop [sum 0 i 0]
      (if (= i num-length)
        sum
        (recur (+ sum (* (Math/pow base (- num-length (+ i 1))) (.indexOf source-lang (str (nth number i))))) (inc i)) ))))

(defn translate-number [number source-lang target-lang]
  (let [num-len (count number)
        base (count source-lang)
        new-base (count target-lang)
        value-to-translate (to-base-ten number source-lang base)
        largest-exponent (Math/floor (/ (Math/log value-to-translate) (Math/log new-base)))]
    (loop [i (int largest-exponent) out-num "" valtr value-to-translate]
      (if (= i -1)
        out-num
          (if (and (> (Math/pow new-base (+ i 1)) valtr)  (<= (Math/pow new-base i)  valtr))
          (let [ret (loop [j 0 sum2 out-num valtr2 valtr]
                        (if (= j new-base)
                            [sum2 valtr2]
                            (if (> (* (+ j 1) (Math/pow new-base i)) valtr2)
                              [(str sum2 (nth target-lang j)) (- valtr2 (* j (Math/pow new-base i)))]
                              (recur (inc j) sum2 valtr2))))]

              (recur (dec i) (first ret) (second ret)))
            (recur (dec i) (str out-num (first target-lang)) valtr))))))





(defn alien-numbers []
  (let [lines (read-lines infile)
        nCases (read-string (first lines))
        out-file outfile]
   (with-open [writer (writer out-file)]
     (loop [l 1]
       (if (= l (inc nCases))
         "Done"
         (let [l-parse (split (nth lines l) #" ")
              out (translate-number (first l-parse) (second l-parse) (nth l-parse 2))]
           (do
              (.write writer (str "Case #" l ": " out))
               (.newLine writer)
             (recur (inc l)))))))))

(alien-numbers)
(.indexOf "hej" (str(second "he")))

