FROM gradle:jdk17 as build
COPY . /app
WORKDIR /app
RUN gradle build -x test

FROM openjdk:17-jdk-oracle
EXPOSE 8080
COPY --from=build /app/build/libs/Message-App-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]