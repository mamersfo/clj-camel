(ns clj-camel.weather
  (:import [com.cdyne.wsf Weather]))

(def service (Weather.))

(defn get-city-weather-by-zip
  [zip]
  (let [result (-> (.getWeatherSoap service)
                   (.getCityWeatherByZIP zip))]
    (.getTemperature result)))
