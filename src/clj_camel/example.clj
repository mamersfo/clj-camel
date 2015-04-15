(ns clj-camel.example
  (:require [clj-camel.weather :refer [get-city-weather-by-zip]]
            [clj-camel.core :as camel :refer [defroute]]))

(defprotocol WeatherService
  (getit [this zip]))

(deftype WeatherBean []
  WeatherService
  (getit [this zip]
    (get-city-weather-by-zip zip)))

(defroute foo
  (.from (str "quartz://myTimer?"
              "trigger.repeatInterval=2000&"
              "trigger.repeatCount=3"))
  (.setBody)
  (.simple "22043")
  (.bean (WeatherBean.) "getit")
  (.to "file:data/outbox"))

(defn run
  []
  (let [ctx (camel/start foo)]
    (Thread/sleep 10000)
    (camel/shutdown ctx)))
