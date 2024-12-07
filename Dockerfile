FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/api-service.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080
