FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./../target/demo-1.0-SNAPSHOT.jar.jar app.jar
EXPOSE 8898
ENTRYPOINT ["java","-jar","/app.jar"]