(ns clj-camel.example
  (:require [clj-camel.core :as camel :refer [defroute]]))

(defroute kafka
  (.from (str "kafka:192.168.59.103:9092?"
              "topic=test&"
              "zookeeperHost=192.168.59.103&"
              "zookeeperPort=2181&"
              "groupId=camel"))
  (.to "log:clj-camel.example?level=INFO&showAll=true&multiline=true")
  (.to "file:data/out"))

(defn run
  []
  (let [ctx (camel/start kafka)]
    (Thread/sleep 60000)
    (camel/shutdown ctx)))
