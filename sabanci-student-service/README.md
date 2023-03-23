### Dockerfile;
```
FROM openjdk:17-oracle
EXPOSE 8080
ADD target/*.jar student-service.jar
ENTRYPOINT ["java","-jar","/student-service.jar"]
```
### Docker commands;
* maven ---->
```
mvn clean install
```
* Docker image oluşturma --->
```
docker build -t <image_name> .
```

* Docker container koşma --->
```
docker run -p 8080:8080 <tag_name>
```

* Docker push ---->
```
docker login
docker images 
docker tag <image_id> korayguney/<image_name>:latest
docker push korayguney/<image_name>
```

* docker-compose;
```
version: "3.8"
services:
  backend:
    image: "korayguney/student-service"
    ports:
      - "80:8080"
    restart: "always"
##   environment:
##     SPRING_PROFILES_ACTIVE: prod
```

* AWS Postgres RDS'e lokalden bağlanma;
```
docker run -it --rm postgres:alpine psql -h awseb-e-3vdcbgjmf3-stack-awsebrdsdatabase-asasr5udpxuw.cxwdf9twl8id.eu-central-1.rds.amazonaws.com -U korayguney -d postgres
```