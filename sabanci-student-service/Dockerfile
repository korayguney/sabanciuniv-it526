FROM openjdk:17-oracle
EXPOSE 8080
ADD target/*.jar students.jar
ENTRYPOINT ["java","-jar","students.jar"]