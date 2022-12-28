FROM openjdk:8
EXPOSE 8081
ADD target/docker-boss-service.jar docker-boss-service.jar
ENTRYPOINT ["java","-jar","/docker-boss-service.jar"]
