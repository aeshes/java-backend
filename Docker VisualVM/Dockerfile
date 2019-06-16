FROM bellsoft/liberica-openjdk-alpine:11.0.3
COPY ./target/test-1.0.jar app.jar
EXPOSE 8080
EXPOSE 1026
CMD java -XX:+UseContainerSupport -Xmx1g -Xms1g -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1026 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar app.jar