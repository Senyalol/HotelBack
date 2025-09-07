FROM maven:3.9.9-eclipse-temurin-23 AS build

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests


FROM eclipse-temurin:23-jre-alpine

WORKDIR /apphotel

COPY --from=build /app/target/*.jar hotel.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "hotel.jar"]