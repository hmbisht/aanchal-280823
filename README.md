# Progressive webapp with React, Spring Boot, MySQL and many more

Hi there! This app is an spring-boot application which uses MySql database, Swagger documentation, liquibase as data migration tool etc.
I'll try to use more features of java related technologies in future.

This app is working with Java 11.

## The purpose of the webapp

The purpose of the app was to learn as to : 

 1. How to build Spring Boot apps?
 4. How to deploy React and Spring Boot along with MySQL DB in Google Cloud?
 5. How to use swagger2 to document and use your REST APIs
    http://{PROJECT_NAME}/appspot.com/swagger-ui.html

### Installation

You'll need maven and JAVA pre-installed, which most probably you'll already have.  To run the application, run the following commands from the console.

```sh
$ mvn clean
$ mvn package
$ java -jar target/aanchal-0.0.1-SNAPSHOT.jar
```

Later I've planned it to deploy in Google Cloud. I'll be using kubernetes cluster management.