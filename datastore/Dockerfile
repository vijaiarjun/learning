FROM maven:3.5.4-jdk-8-alpine
COPY /datastore/pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY /datastore/src ./src
RUN mvn package && cp ./target/*.jar ./app.jar