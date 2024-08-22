(ns com.iraqidata.tasks.day-2
  (:require
   [clojure.string :as str]
   scicloj.clay.v2.api
   [tablecloth.api :as tc]
   tech.v3.datatype.casting))

(def ds (tc/dataset "./resources/data/flights.csv"
                    {:key-fn #(keyword (str/replace (name %) "_" "-"))}))

;; 1. How many flights were there in total?

(count (tc/rows ds))
;; => 336776

;; this might include the cancelled flights too.

;; Correct, 1 point

;; 2. How many unique carriers were there in total?
(->> (tc/column ds :carrier)
     set
     count)
;; Correct, 1 point

;; 3. How many unique airports were there in total?
(->> (concat
      (tc/column ds :origin)
      (tc/column ds :dest))
     set
     count)
;; => 107

;MY NOTE:: I thought of doing each one of the columns as a set and then doing
;another set Function on them, but it required adding clojure.set which I
;refrained from doing, so I merged the 2

;; Correct, 1 point

;; 4. What is the average arrival delay for each month?
                                        ; my initial thought would be to group by month and make each month have a mean of average delay, but I am not able to do so
(->> (tc/group-by ds :month)) ; here it would be forwarded to be made into new sets where each set would have a mean operation on it

;; You were close to the answer, you only needed to run `tc/mean` with a thread first

(-> ds
    (tc/group-by :month)
    (tc/mean :arr-delay)
    (tc/order-by :$group-name))

;; Optional: Use the `airlines` dataset to get the name of the carrier with the
;; highest average distance.

(def airlines
  (tc/dataset "./resources/data/airlines.csv"
              {:key-fn keyword}))

;; Final score: 3
