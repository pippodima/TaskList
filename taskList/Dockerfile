# Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/taskList-1.0-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]

