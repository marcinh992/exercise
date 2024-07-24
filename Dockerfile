FROM maven:3.9.6-amazoncorretto-17 AS builder
WORKDIR /app
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=false

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/starservice-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["sh", "-c", "java -jar app.jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE"]
