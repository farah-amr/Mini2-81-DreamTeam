# Use a base JDK image
FROM openjdk:25-ea-4-jdk-oraclelinux9

# Set working directory
WORKDIR /app

# Copy and build the app (assumes you have built with Maven already)
COPY target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
