Postman collection: https://www.getpostman.com/collections/58f033d960931c2d0c56  
Heroku app url: http://cp-avengers.herokuapp.com/

This Spring Boot application is rebuilt and deployed on Heroku with every new commit to this branch.  
  
To build and run locally run the following command: 
./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar
or
mvn clean install && java -jar target/gs-spring-boot-0.1.0.jar

when running locally, then the app url is http://localhost:8080/
