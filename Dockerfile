FROM openjdk:8-alpine
VOLUME /tmp
ARG JAR_FILE
ADD /target/docker-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]