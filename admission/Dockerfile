FROM openjdk:8
EXPOSE 8081
ADD target/docker-admission-service.jar docker-admission-service.jar
ENTRYPOINT ["java","-jar","/docker-admission-service.jar"]
