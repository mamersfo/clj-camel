(defproject clj-camel "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.apache.camel/camel-core "2.15.1"]
                 [org.apache.camel/camel-stream "2.15.1"]
                 [org.apache.camel/camel-quartz "2.15.1"]
                 [org.apache.camel/camel-hdfs2 "2.15.1"]
                 [org.apache.camel/camel-kafka "2.15.1"
                  :exclusions [[javax.jms/jms :classifier "*"]
                               com.sun.jdmk/jmxtools
                               com.sun.jmx/jmxri]]
                 [org.scala-lang/scala-library "2.10.4"]])
