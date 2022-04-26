FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} health-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/health-service-0.0.1-SNAPSHOT.jar"]