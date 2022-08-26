FROM openjdk:11
EXPOSE 8091
ADD target/department-service.jar department-service.jar
ENTRYPOINT ["java","-jar","/department-service.jar"]