# Spring Boot MySQL Application

This is a simple Spring Boot application that uses a MySQL database. It demonstrates basic CRUD operations with Spring Data JPA.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- [Java JDK 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)

## Getting Started

1. **Clone the repository**
    ```sh
    git clone https://github.com/yourusername/spring-boot-mvc-crud.git
    cd spring-boot-mysql-app
    ```

2. **Set up the MySQL database**
```sh
CREATE DATABASE  IF NOT EXISTS `family_directory`;
USE `family_directory`;

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;

CREATE TABLE `family` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `age` INTEGER DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `family`
--

INSERT INTO `family` VALUES 
	(1,'John','Smith', 55),
	(2,'Boby','Owen', 42),
	(3,'Tom','Rah', 14),
	(4,'Ken','Smith', 10),
	(5,'Rony','Cane', 3);
    ```

3. **Configure database connection properties**

    Update the `src/main/resources/application.properties` file with your database connection details:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/family_directory
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```

## Configuration

- **application.properties**: Configuration file for database connection and other application settings.
- **pom.xml**: Maven configuration file for managing dependencies.

## Running the Application

You can run the application in several ways:

1. **Using Maven**
    ```sh
    mvn spring-boot:run
    ```

2. **Using your IDE**
    - Import the project as a Maven project in your IDE.
    - Run the `Application.java` file.

## API Endpoints

The application provides the following endpoints:

- **GET /api/entities**: Retrieve all entities.
- **GET /api/entities/{id}**: Retrieve a single entity by ID.
- **POST /api/entities**: Create a new entity.
- **PUT /api/entities/{id}**: Update an existing entity by ID.
- **DELETE /api/entities/{id}**: Delete an entity by ID.

## Testing

To run tests, use the following command:
```sh
mvn test
```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License.


