# Art Sales System
This is a Java/Maven/Spring Boot (version 2.7.2) application for art work sales as well as provide other services like inventory and security.

## Technology
* Java 17
* Spring Boot 2.7.2
* Spring Security
* Spring Data Jpa for Persistence
* Maven 3.0+

## About the Service
This service makes use of REST service. H2 is the in-memory database used to store it data. PostgreSQL relational database can also be used as it is one of the pom.xml dependencies of the project.
This application demonstrates the following:
* Automatic CRUD functionality using Spring Repository pattern
* RESTful service using annotation which supports both XML and JSON request/response
* Spring Data Integration with JPA/Hibernate with familiar annotations and few lines of configuration
* Security to authenticate and authorize users.
