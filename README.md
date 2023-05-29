# Art Sales System
This is a Java/Maven/Spring Boot(version 2.7.2) application for art work sales. It also provide other services like inventory and security.

## Table of Contents

- [Project Name](#project-name)
  - [Table of Contents](#table-of-contents)
  - [About the Service](#about-the-service)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Project](#running-the-project)
  - [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Contributing](#contributing)
  - [License](#license)
  - [Contact](#contact)
  
  
## About the Service
This service makes use of REST service. H2 is the in-memory database used to store it data. PostgreSQL relational database can also be used as it is one of the pom.xml dependencies of the project.
This application demonstrates the following:
* Automatic CRUD functionality using Spring Repository pattern
* RESTful service using annotation which supports both XML and JSON request/response
* Spring Data Integration with JPA/Hibernate with familiar annotations and few lines of configuration
* Security to authenticate and authorize users
 

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java](https://www.java.com/) (version 17 or higher)
- [Maven](https://maven.apache.org/) (version 3.0 or higher)
- [Spring Boot](https://spring.io/) (version 2.7.2 or higher)
- [Postgres](https://www.postgresql.org/) (version 15.2 or higher)

### Installation

1. Clone the repository to your local machine:

```bash
git clone https://github.com/Adejumok/ArtSalesSystem
```

2. Change directory to the project folder:

```bash
cd artSalesSystem
```

3. Create a Postgres database and update the database connection details in the `application.properties` file.

4. Build the project using Maven:

```bash
mvn package
```

### Running the Project

To run the project locally, follow these steps:

```bash
java -jar target/artSalesSystem-X.X.X.jar
```

The application will be running at `http://localhost:8080`.


## Usage

### Prerequisites

Before using this project, ensure that you have the following software installed on your machine:

- Java 17 or later
- Maven

### Running the Project

To run the project, follow these steps:

1. Clone the repository to your local machine:

```bash
git clone https://github.com/Adejumok/ArtSalesSystem
```

2. Change to the project directory:

```bash
cd artSalesSystem
```

3. Build the project with Maven:

```bash
mvn clean install
```

4. Start the application with Maven:

```bash
mvn spring-boot:run
```

The application will start and be available at `http://localhost:8080`. You can access the API endpoints using your preferred HTTP client, such as [Postman](https://www.postman.com/) or `curl`.

### API Endpoints

Here are the available API endpoints:

| Method | Endpoint | Description |
| ------ | -------- | ----------- |
| POST   | /api/v1/auth/register | Registers a new user. |
| POST    | /api/v1/auth/login | Authenticates the user using the email and password. |
| GET    | /api/v1/art/getAllArts | Returns a list of all arts. |
| GET    | /api/v1/art/getArt/{artId} | Returns the art with the specified ID. |
| POST   | /api/v1/art/addArt | Adds a new art. |
| PATCH    | /api/v1/art/update/{artId} | Updates the art with the specified ID. |
| DELETE | /api/v1/art/deleteBook/{artId} | Deletes the art with the specified ID. |

### Examples

Here are a few examples of how to use this project:

#### Example 1: Getting all arts

To get a list of all arts, send a `GET` request to `/api/v1/art/getAllArts`.

#### Example 2: Adding a new art


```json
{
  "artTitle": "New Title",
  "artType": "Sculpture",
  "artPrice": 289.00,
  "artDescription": "A new kinda art"

}
```

#### Example 3: Updating a art data

To update an existing item, send a `PATCH` request to `/api/items/{id}` with a JSON payload containing the updated user's data.

```json
{
  "artTitle": "Updated Title",
  "artType": "Sculpture",
  "artPrice": 299.00,
  "artDescription": "An updated kinda art"

}
```

## Contributing

If you'd like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and commit them with descriptive commit messages.
4. Push your changes to your forked repository.
5. Submit a pull request to the original repository.

## License

This project is licensed under the [Apache License 2.0](LICENSE).

## Contact

Please feel free to contact me if you have any questions or feedback.

- Email: roseadeyinka01@example.com
- GitHub: https://github.com/Adejumok
