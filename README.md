# clj-camel

Example defines a route that is triggered by a Quartz scheduler, and invokes a SOAP request every two seconds.

## Usage

### Generate Weather Service classes

    mkdir -p target/classes
    cd target/classes
    wsimport -p com.cdyne.wsf http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL

### Running the route

Spin up a REPL and invoke the `run` function in `example.clj`
