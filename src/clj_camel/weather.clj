(ns clj-camel.weather
  (:import [com.cdyne.wsf Weather]))

(def service (Weather.))

(defn get-city-weather-by-zip
  [zip]
  (let [result (-> (.getWeatherSoap service)
                   (.getCityWeatherByZIP zip))]
    (.getTemperature result)))

(defprotocol WeatherProtocol
  (getit [this zip]))

(deftype WeatherBean []
  WeatherProtocol
  (getit [this zip]
    (get-city-weather-by-zip zip)))
