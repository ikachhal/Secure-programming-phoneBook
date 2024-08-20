FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install

FROM openjdk:11-jre-slim

RUN apt-get update && apt-get install -y sqlite3
RUN mkdir -p /sqlite_data
RUN chmod -R 777 /sqlite_data
WORKDIR /sqlite_data
COPY inaAssignment.db /sqlite_data/inaAssignment.db

COPY --from=build /home/app/target/assignment-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]