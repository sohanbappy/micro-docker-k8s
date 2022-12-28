FROM openjdk:8
EXPOSE 8081
ADD target/docker-doctor-service.jar docker-doctor-service.jar
ENTRYPOINT ["java","-jar","/docker-doctor-service.jar"]
