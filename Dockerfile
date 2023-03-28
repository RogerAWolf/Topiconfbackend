FROM maven:3.8.5-openjdk-11 as build
WORKDIR /src/main/java/nl/topicus/topiconfbackend
COPY . .
RUN mvn --batch-mode package
RUN cp target/*jar target/app.jar

FROM openjdk:18-ea-11-jdk-alpine3.15
USER 1000
ENTRYPOINT ["java","-jar", "./app.jar"]
EXPOSE 8082
COPY --from=build /usr/src/scaffolded/target/app.jar app.jar 
