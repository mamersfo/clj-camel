(ns clj-camel.soap
  (:require [clj-camel.weather :as weather]
            [clj-camel.core :as camel :refer [defroute]]))

(defroute soap-route
  (.from (str "quartz://myTimer?"
              "trigger.repeatInterval=2000&"
              "trigger.repeatCount=3"))
  (.setBody)
  (.simple "22043")
  (.bean (clj_camel.weather.WeatherBean.) "getit")
  (.to "file:data/outbox"))

(defn run
  []
  (let [ctx (camel/start soap-route)]
    (Thread/sleep 10000)
    (camel/shutdown ctx)))
