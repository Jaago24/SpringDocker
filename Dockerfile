FROM openjdk:17
# Set the working directory inside the container
#WORKDIR /app

# Copy the JAR file from the host to the container
ADD target/springboot_tutorial.jar springboot_tutorial.jar

# Specify the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "springboot_tutorial.jar"]