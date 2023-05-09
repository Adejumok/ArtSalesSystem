# Art Sales System
This is a Java/Maven/Spring Boot(version 2.7.2) application for art work sales. It also provide other services like inventory and security.

## Table of Contents

- [Project Name](#project-name)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Project](#running-the-project)
  - [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Contributing](#contributing)
  - [License](#license)
  - [Contact](#contact)

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
git clone https://github.com/Adejumok/LibraryServiceSystem
```

2. Change directory to the project folder:

```bash
cd project-name
```

3. Create a Postgres database and update the database connection details in the `application.properties` file.

4. Build the project using Maven:

```bash
mvn package
```

### Running the Project

To run the project locally, follow these steps:

```bash
java -jar target/project-name-X.X.X.jar
```

The application will be running at `http://localhost:8080`.


## Usage

### Prerequisites

Before using this project, ensure that you have the following software installed on your machine:

- Java 11 or later
- Maven

### Running the Project

To run the project, follow these steps:

1. Clone the repository to your local machine:

```bash
git clone https://github.com/Adejumok/LibraryServiceSystem
```

2. Change to the project directory:

```bash
cd project-name
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
| GET    | /getAllUsers | Returns a list of all users. |
| GET    | /user/{id} | Returns the user with the specified ID. |
| POST   | /signup | Adds a new user. |
| POST   | /login | validates an existing user using email and password. |
| PATCH    | /update/{id} | Updates the user with the specified ID. |
| GET    | /getBook/{isbn} | Returns the book with the specified ISBN. |
| POST   | /addBook | Adds a new book. |
| DELETE | /deleteBook/{isbn} | Deletes the book with the specified ISBN. |

### Examples

Here are a few examples of how to use this project:

#### Example 1: Getting all users

To get a list of all users, send a `GET` request to `/getAllUsers`.

#### Example 2: Adding a new user

To add a new user, send a `POST` request to `/signup` with a JSON payload containing the user data.

```json
{
  "firstName": "New Name",
  "email": "user@gmail.com",
  "password": "user's password"
}
```

#### Example 3: Updating a user data

To update an existing item, send a `PATCH` request to `/api/items/{id}` with a JSON payload containing the updated user's data.

```json
{
  "firstName": "Updated Name",
  "email": "user@gmail.com",
  "password": "user's password"
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

This project is licensed under the [MIT License](LICENSE).

## Contact

Please feel free to contact me if you have any questions or feedback.

- Email: roseadeyinka01@example.com
- GitHub: https://github.com/Adejumok

## About the Service
This service makes use of REST service. H2 is the in-memory database used to store it data. PostgreSQL relational database can also be used as it is one of the pom.xml dependencies of the project.
This application demonstrates the following:
* Automatic CRUD functionality using Spring Repository pattern
* RESTful service using annotation which supports both XML and JSON request/response
* Spring Data Integration with JPA/Hibernate with familiar annotations and few lines of configuration
* Security to authenticate and authorize users.
