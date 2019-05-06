FROM openjdk:8-alpine

ADD target/crud-demo.jar docker-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "docker-app.jar"]