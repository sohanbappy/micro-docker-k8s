FROM openjdk:8
EXPOSE 8989
ADD target/docker-gateway-service.jar docker-gateway-service.jar
ENTRYPOINT ["java","-jar","/docker-gateway-service.jar"]
