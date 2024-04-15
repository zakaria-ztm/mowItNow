FROM openjdk:17-ea-slim-buster
WORKDIR /opt
ADD target/mower-*.jar mower-application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/mower-application.jar"]