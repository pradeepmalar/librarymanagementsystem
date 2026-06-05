# LMS (Library Management System)

This repository contains a Java Spring Boot backend and a React frontend for a simple library management system.

## Project structure

- `src/main/java/com/library/` - Spring Boot application code
- `src/main/resources/application.properties` - backend configuration
- `build.gradle.kts` - Gradle build script for the backend
- `library-frontend/` - React frontend application

## Backend

The backend is a Spring Boot application using:

- Spring Boot 3.3.0
- Spring Web
- Spring Data JPA
- MySQL Connector/J
- Spring Validation

### Requirements

- Java 17
- Gradle wrapper (`./gradlew` / `gradlew.bat`)
- MySQL database

### Configuration

Update `src/main/resources/application.properties` with your database settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/feedback_db
spring.datasource.username=root
spring.datasource.password=Prad@2002
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
```

> Important: Do not commit production credentials. Use environment-specific configuration or secrets management for deployed apps.

### Run backend

From the project root:

```bash
./gradlew bootRun
```

Or build and run:

```bash
./gradlew build
java -jar build/libs/LMS-1.0.jar
```

## Frontend

The frontend is a React app located in `library-frontend/`.

### Requirements

- Node.js
- npm

### Run frontend

From `library-frontend/`:

```bash
npm install
npm start
```

### Build frontend

```bash
npm run build
```

## Notes

- The backend currently runs on port `8080`.
- The frontend is created with `create-react-app` and uses `react-scripts`.
- If you add environment-specific settings, add them to `.gitignore` as needed to avoid committing secrets.

## Git ignore

This repo ignores:

- Gradle build artifacts
- IDE files
- OS files
- Node modules and frontend build output
- generated and temporary build directories
- environment files
