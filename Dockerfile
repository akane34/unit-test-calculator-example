FROM openjdk:21-jdk-slim

LABEL org.opencontainers.image.title="unit-test-calculator-example" \
      org.opencontainers.image.description="Docker image for unit-test-calculator-example" \
      org.opencontainers.image.version="1.0"

WORKDIR /app

COPY runner/build/libs/*.jar /app/app.jar

EXPOSE 8080

ENV ENVIRONMENT=local
CMD ["java", "-jar", "-Dspring.profiles.active=${ENVIRONMENT}", "app.jar"]