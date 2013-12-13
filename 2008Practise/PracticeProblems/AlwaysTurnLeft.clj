(ns alwaysTurnLeft
  ( use [clojure.java.io  only [reader writer]]
        [clojure.string  only [split]])
  ( import (java.io File)))

(def infile "c \\gcj\\2008Practise\\PracticeProblems\\B-small-practice.in")
(def outfile "c \\gcj\\2008Practise\\PracticeProblems\\B-small-practice.out.clj")
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



(defn add-to-cell [c p d steps]
  (let [cells-out (if (not (contains? (map first c) p)) (conj c [[p] 0 0 0 0]) c)
        ])

  )

   def addToCell(cells,position,direction,step):
    if (not position in [x[0] for x in cells]):
        cells.append([position,0,0,0,0])

    cell = [x for x in cells if (x[0] == position)]
    cell = cell[0]

    if(step == 'W'):
        if (direction == [1, 0]):
            cell[3] = 1
        elif (direction == [-1, 0]):
            cell[4] = 1
        elif (direction == [0, 1]):
            cell[1] = 1
        else:
            cell[2] = 1

    return cells

(defn step-done [steps pos dir cells-out]
  (loop [s 0 p pos d dir c cells-out]
    (if (= s (count steps))
      [(rest c) d p]
      (if (= [steps s] \W)
        (recur (inc s) [(+ p[0] d[0]) (+ p[1] d[1])] d (add-to-cell c p d steps[s]))
        (recur (inc s) p (step-permute d) (add-to-cell c p d steps[s]))))))









(defn get-cells [walks]
  (let [walkss (split walks #" ")
        cells []
        direction  [0, -1]
        position [0, -1]]
    (loop [w 0 cells-out cells dir direction pos position]
      (if (= w (count walkss))
        cells-out
        (let [direct (map #(* % -1) direction)
              steps [into [] w]
              step-res (step-done steps pos dir cells-out)]
          (recur (inc w) (first step-res) (second step-res) (nth step-res 2)))))))



(defn always-turn-left []
  (let [lines (read-lines infile)
        nCases (read-string (first lines))
        types {"[1, 0, 0, 0]" "1", "[0, 1, 0, 0]"   "2", "[1, 1, 0, 0]"   "3", "[0, 0, 1, 0]"   "4",
             "[1, 0, 1, 0]"   "5", "[0, 1, 1, 0]"   "6", "[1, 1, 1, 0]"   "7", "[0, 0, 0, 1]"   "8",
             "[1, 0, 0, 1]"   "9", "[0, 1, 0, 1]"   "a", "[1, 1, 0, 1]"   "b", "[0, 0, 1, 1]"   "c",
             "[1, 0, 1, 1]"   "d", "[0, 1, 1, 1]"   "e", "[1, 1, 1, 1]"   "f"}
        out-file outfile]
    (loop [l 1 cells []]
      (if (= l (inc (count lines)))
        "Done"
        (let [cells (get-cells [lines l])]
          cells_)))))


(into [] "hej")