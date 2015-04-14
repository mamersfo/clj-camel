(ns clj-camel.example
  (:require [clj-camel.core :as camel :refer [defroute]]))

(defroute foo
  (.from "timer://myTimer?period=2000")
  (.setBody)
  (.simple "Current time is ${header.firedTime}")
  (.to "file:data/outbox"))

;; (def ctx (camel/start foo))
;; (camel/shutdown ctx)

