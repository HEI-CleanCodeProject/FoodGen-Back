FROM maven:3.9.6-eclipse-temurin-11 AS build

WORKDIR /project

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /project/src

RUN mvn package

FROM openjdk:17-jdk-slim AS builder

RUN mkdir /app

COPY --from=build /project/target/food-gen-back-O.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

RUN chown -R userfood:usergroup /app

EXPOSE 8000

CMD java $JAVA_OPTS -jar bmi.jar