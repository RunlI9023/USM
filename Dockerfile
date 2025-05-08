FROM openjdk:17-alpine
WORKDIR /usmapp
COPY target/usm-0.0.1-SNAPSHOT.jar /usmapp/usm.jar
ENTRYPOINT ["java", "-jar", "usm.jar"]