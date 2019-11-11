FROM maven:3.5.4-jdk-8-alpine
RUN mvn dependency:go-offline -B
RUN mvn package && cp target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]