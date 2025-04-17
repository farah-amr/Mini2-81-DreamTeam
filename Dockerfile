# Use a base JDK image
FROM openjdk:25-jdk-slim

# Set working directory
WORKDIR /app

# Copy and build the app (assumes you have built with Maven already)
COPY target/*.jar app.jar

EXPOSE 8080
# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
