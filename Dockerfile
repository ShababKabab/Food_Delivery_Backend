FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/zosh-food-0.0.1-SNAPSHOT.jar zosh-food.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","zosh-food.jar"]