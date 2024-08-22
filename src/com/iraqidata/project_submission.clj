(ns com.iraqidata.project-submission
  (:require
   [muuntaja.core :as muuntaja]
   [reitit.coercion.malli :as malli]
   [reitit.ring :as ring]
   [reitit.ring.coercion
    :refer [coerce-request-middleware coerce-response-middleware]]
   [reitit.ring.middleware.muuntaja
    :refer [format-negotiate-middleware format-request-middleware
            format-response-middleware]]
   [reitit.ring.middleware.parameters :refer [parameters-middleware]]
   [ring.adapter.jetty :as jetty]
   [tablecloth.api :as tc]))


;;;; # Data Analysis

(def ds
  (tc/dataset "./resources/project/data-clean.csv"
              {:key-fn keyword}))

;;;; # Backend Setup

(def app
  (ring/ring-handler
   (ring/router ["/api"
                 ["/sales-trend" {:get (fn [_]
                                         {:body "TODO"})}]
                 ["/top-customers" {:get (fn [_]
                                           {:body "TODO"})}]]
                {:data {:coercion malli/coercion
                        :muuntaja muuntaja/instance
                        :middleware [parameters-middleware

                                     format-negotiate-middleware
                                     format-response-middleware
                                     format-request-middleware

                                     coerce-request-middleware
                                     coerce-response-middleware]}})))
;;;; # server

(def server
  (jetty/run-jetty #'app
                   {:port 3333
                    :join? false}))


;;;; # `-main`

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (jetty/run-jetty #'app
                   {:port 3333
                    :join? false}))
