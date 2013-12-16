(ns alwaysTurnLeft
  (:use [clojure.java.io  :only [reader writer]]
        [clojure.string  :only [split]])
  (:import (java.io File)))

(def infile "c:\\gcj\\2008Practise\\PracticeProblems\\B-large-practice.in")
(def outfile "c:\\gcj\\2008Practise\\PracticeProblems\\B-large-practice.out.clj")
;(def infile "/home/andreask/gcj/2008Practise/PracticeProblems/B-small-practice.in")
;(def outfile "/home/andreask/gcj/2008Practise/PracticeProblems/B-small-practice.out.clj")


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




(defn step-permute [dir step]
  (cond
   (= step \L)
     (cond
      (= dir [0, 1]) [1, 0]
      (= dir [0, -1]) [-1, 0]
      (= dir [1, 0]) [0, -1]
      true [0, 1])
   (= step \R)
     (cond
      (= dir [0, 1]) [-1, 0]
      (= dir [0, -1]) [1, 0]
      (= dir [1, 0]) [0, 1]
      true [0, -1])
   true dir))


(defn add-to-cell [c p d step]
  (let [cells-out (if (not (some #(= % p) (map first c))) (vec (conj c [p 0 0 0 0])) (vec c))
        cell (first (filter (fn [x] (= p (first x))) cells-out))
        cell-pos (.indexOf (map first cells-out) p)]
    (do
;      (print "in add to")
;      (print c)
    (if (= step \W)

      (cond
       (= [1, 0] d) (assoc cells-out cell-pos (assoc cell 3 1))
       (= [-1, 0] d) (assoc cells-out cell-pos (assoc cell 4 1))
       (= [0, 1] d) (assoc cells-out cell-pos (assoc cell 1 1))
       true (assoc cells-out cell-pos (assoc cell 2 1)))
      cells-out))))



(defn step-done [steps pos dir cells-out]
  (do
;    (print "in step done")
  (loop [s 0 p pos d dir c cells-out]
    (if (= s (count steps))
      (do
;        (print "fins")
      [(butlast c) d p])
      (do
;        (print (nth steps s))
      (if (= (nth steps s) \W)
        (let [new-pos [(+ (first p)  (first d)) (+ (second p) (second d))]]
          (recur (inc s) new-pos d (add-to-cell c new-pos d (nth steps s))))
        (recur (inc s) p (step-permute d (nth steps s)) (add-to-cell c p d (nth steps s)))))))))









(defn get-cells [walks]
  (let [walkss (split walks #" ")
        cells []
        direction  [0, -1]
        position [0, -1]]
    (loop [w 0 cells-out cells dir direction pos position]

      (if (= w (count walkss))
        cells-out
        (let [direct (map #(* % -1) dir)
              steps (into [] (nth walkss w))
              step-res (step-done steps pos direct cells-out)]
           (do
;             (print steps)
          (recur (inc w) (first step-res) (second step-res) (nth step-res 2))))))))



(defn always-turn-left []
  (let [lines (read-lines infile)
        nCases (read-string (first lines))
        types {"[1 0 0 0]" "1", "[0 1 0 0]"   "2", "[1 1 0 0]"   "3", "[0 0 1 0]"   "4",
             "[1 0 1 0]"   "5", "[0 1 1 0]"   "6", "[1 1 1 0]"   "7", "[0 0 0 1]"   "8",
             "[1 0 0 1]"   "9", "[0 1 0 1]"   "a", "[1 1 0 1]"   "b", "[0 0 1 1]"   "c",
             "[1 0 1 1]"   "d", "[0 1 1 1]"   "e", "[1 1 1 1]"   "f"}
        out-file outfile]

    (with-open [writer (writer out-file)]
      (loop [case 1]
      (if (= case (inc nCases))
          "Done"
          (do
            (.write writer (str "Case #" case ":"))
            (.newLine writer)
            (loop [row 0]
              (let [sort-cells (sort-by (juxt (fn [x] (second (first x))) (fn [x] (first (first x)))) (get-cells (nth lines case)))
                    ress (filter (fn [x] (= row (second (first x)))) sort-cells)]
              (if (= 0 (count ress))
               "Done"
                (let [ln (reduce str (map (fn [x] (types (str (vec (rest x))))) ress))]
                  (do
                    (.write writer (str ln))
                     (.newLine writer)
                (recur (inc row)))))))
            (recur (inc case))))))))
;    (loop [l 1 cells []]
;      (if (= l (inc (count lines)))
 ;       "Done"
;        (let [cells (get-cells (nth lines l))
;              sorted-cells (sort-by (juxt (fn [x] (second (first x))) (fn [x] (first (first x)))) cells)]
;          cells)))))

(always-turn-left)

(str (vec (rest [[0 1] 0 7])))

;(conj )
;(replace [0 2 77] (list 0 1 2 3 4))


