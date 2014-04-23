(ns genotic.scales)

(defn lower [note]
    (if (< note 20.0)
          note
          (lower (/ note 2))))

(defn equaltemp
    ([] (equaltemp (lower 440.0) (vector)))
    ([a] (equaltemp (lower a) (vector)))
    ([a acc]
       (if (> a 20000.0)
             (vec(reverse acc))
             (equaltemp (* a (Math/pow 2.0 (/ 1.0 12.0))) (cons a acc)))))
(def equaltemps (equaltemp))

(count equaltemps)

