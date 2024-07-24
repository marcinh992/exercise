# StarService Project

## Overview

The StarService project is a Spring Boot application designed to manage a collection of star objects, 
providing various functionalities through a REST API. This project demonstrates the use of several modern technologies and 
frameworks including Spring Boot, Docker, Flyway, MapStruct, Lombok, PostgreSQL, and Swagger for API documentation.

## Project Setup and Build

1. Open terminal and go to project folder
2. Run command "docker compose -f docker-compose up --build"
3. Should run two container with database service and backend service

## Accessing the Application

Once the application is successfully built and running, you can access the REST API documentation at:

http://localhost:8080/swagger-ui/index.html

## Key Technologies and Features

## Spring Boot
Spring Boot is the core framework used to build the application, providing comprehensive infrastructure support for developing Java applications.

## Docker and Docker Compose
Docker: Used for containerizing the application, ensuring consistent environments across different deployment stages.
Docker Compose: Simplifies the setup and running of multi-container Docker applications. 
It is used to run both the PostgreSQL database and the Spring Boot application in separate containers.

## PostgreSQL
PostgreSQL is used as the relational database for storing star data. It is set up and managed using Docker Compose.

## Flyway
Flyway is used for database migrations, ensuring the database schema is versioned and up-to-date. 
The migration scripts are located in the src/main/resources/db/migration directory.

## Lombok
Lombok is used to reduce boilerplate code in Java classes. 
It provides annotations to automatically generate getters, setters, constructors, and other common methods.

## MapStruct
MapStruct is used for object mapping, converting entities to DTOs and vice versa. 
This helps in clean separation of concerns between the data persistence and the API layers.

## Swagger
Swagger is integrated into the project for API documentation. 
It provides an interactive UI to explore and test the API endpoints.

## Exception Handling
The application includes a global exception handler (GlobalExceptionHandler) to handle exceptions and provide meaningful error messages to the client. 
For example, if a star is not found, a StarNotFoundException is thrown, which is handled to return a 404 status code with an appropriate message.




