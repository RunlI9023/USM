FROM openjdk:17-jdk
WORKDIR /usmapp
COPY target/usm-0.0.1-SNAPSHOT.jar /usmapp/usm.jar
ENTRYPOINT ["java", "-jar", "usm.jar"]