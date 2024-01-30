FROM maven:3.8.4-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve-dependencies
COPY src ./src
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve-dependencies
COPY src ./src
RUN mvn package -DskipTests
FROM adoptopenjdk:17-jre-hotspot
WORKDIR /app
COPY --from=builder /app/target/food-gen-back 0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "food-gen-back 0.0.1-SNAPSHOT.jar"]

