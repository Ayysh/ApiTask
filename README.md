
# stack overflow

This project is a microservice implementing following usecases.

Usecase 1: Load first 20 newest questions from StackOverflow and store it in DB.
Conditions: Throw the database and run new everytime. Optimize db as required..

Usecase 2: Provide  HTTP GET endpoint to get all the questions in the database

Usecase 3: Provide HTTP GET endpoint to retrieve a single question by id

Usecase 4: Provide HTTP DELETE endpoint to remove a single question by id from the database

Usecase 5: Provide HTTP GET endpoint to retrieve all questions that have specified tags

Usecase 6: Provide HTTP GET endpoint that acts as a Proxy and returns details about a user by id from StackOverflow
Condition: Enable caching.

General Conditions: Perform validation, exception handling, unit testing for all methods, integration testing for api methods.

## Getting started

A quick introduction of the minimal setup you need to get `stackoverflow` up & running.

## Libraries used
Swagger - for API Documentation
Lombok- for ease of using getters and setters


### Building & Running
### Clean and build the project.
 mvn package
 This creates a jar file of project in stackoverflow/target/stackoverflow-0.0.1-SNAPSHOT.jar

## Run the application.
 mvn spring-boot:run
Project runs on http://localhost:9090/swagger-ui.html. If incase you get port already in use then change the port in
application properties and then use.

## Running all tests (unit and integration test)
mvn test

