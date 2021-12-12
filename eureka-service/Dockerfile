FROM maven:3-openjdk-17 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:17
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar eureka-service.jar
ENTRYPOINT ["java","-jar","/eureka-service.jar"]
