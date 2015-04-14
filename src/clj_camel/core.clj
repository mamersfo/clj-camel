(ns clj-camel.core
  (:import [org.apache.camel.impl DefaultCamelContext SimpleRegistry]
           [org.apache.camel.builder RouteBuilder]))

(defmacro defroute
  [name & forms]
  (list 'def name
        (list 'proxy '[org.apache.camel.builder.RouteBuilder] '[]
              (list 'configure '[]
                    (cons '-> (cons 'this forms))))))

(defn start
  [route]
  (let [reg (SimpleRegistry.)
        ctx (DefaultCamelContext. reg)]
    (.addRoutes ctx route)
    (.start ctx)
    ctx))

(defn shutdown
  [ctx]
  (.shutdown ctx)) 
