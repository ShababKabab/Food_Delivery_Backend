#FROM maven:3.8.3-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests

FROM openjdk:17.0.2 -jdk-slim
COPY --from=build /target/backend-food delivery-0.0.1-SNAPSHOT.jar backend-food delivery.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]