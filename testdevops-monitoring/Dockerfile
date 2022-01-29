FROM openjdk:11
EXPOSE 8081
ADD target/testdevops-monitoring.jar dockerelk.jar
ENTRYPOINT ["java", "-jar", "/dockerelk.jar"]