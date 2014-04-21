(ns genotic.core)

(defn new-gene
  ([] (new-gene 1000))
  ([length]
   (take length (repeatedly #(rand-int 2)))))

(defn generation []
   (take 100 (repeatedly #(new-gene))))

(defn fitness [gene]
  (count (filter #(= 1 %) gene)))

(defn maxer [generation]
  (apply max (map #(fitness %) generation)))

(defn evaluate-generation [generation]
  (sort-by #(fitness %) generation))

(evaluate-generation tester)



(def tester (generation))
(maxer tester)


(generation)
