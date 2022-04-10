FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/discovery-service-0.0.1-SNAPSHOT.jar"]