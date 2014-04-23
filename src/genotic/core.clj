(ns genotic.core)

(defn new-gene
  ([] (new-gene 50))
  ([length]
   ; (take length (repeatedly #(rand-int 2)))))
   (take length (repeat 0))))

(defn generation []
   (take 100 (repeatedly #(new-gene))))


(defn fitness [gene]
  (count (filter #(= 1 %) gene)))

(defn evaluate-generation [generation]
  (let [n (/ (count generation) 2)]
    (take n
      (reverse
        (sort-by
          #(fitness %)
          generation)))))

(defn mutate [g]
  (if (= (rand-int 100) 50)
    (bit-flip g 0)))

(defn mutate-gen [generation]
  (map #(map mutate %) generation))

(defn tng [generation]
  (let [ng (evaluate-generation generation)]
    (concat ng
            (mutate-gen ng))))


(defn go [generation]
  (if (= (fitness (first (evaluate-generation generation))) 50)
    (println (first (evaluate-generation generation)))
    (do
      (println (first (evaluate-generation generation)))
      ; (println (fitness (first (evaluate-generation generation))))
      (recur (tng generation)))))


(defn -main []
  (go (generation)))
