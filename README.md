# observability-java-demo

This project implements REST APIs using Spring Boot with Micrometer setup for observability.

## Prerequisites

- Java 17
- Maven
- Docker (optional, for containerization)

## How to Setup and Run

### 1. Clone the Project

```sh
git clone https://github.com/ajay2696/observability-java-demo.git
cd observability-java-demo
```

### 2. Build the Project

```sh
mvn clean install
```

### 3. Run the Project

```sh
mvn spring-boot:run
```

### 4. Access the Application

- The application will be available at `http://localhost:8080`.
- H2 Database console can be accessed at `http://localhost:8080/h2-console`.

## Docker Setup

### 1. Build Docker Image

```sh
docker build -t observability-java-demo .
```

### 2. Run Docker Container

```sh
docker run -p 8080:8080 observability-java-demo
```

## Configuration

### `application.properties`

```ini
spring.application.name=demo
server.port=8080

# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=none

# Actuator
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.endpoint.prometheus.enabled=true
management.metrics.export.prometheus.enabled=true
```

## Endpoints

- `/api/users` - Manage users
- `/actuator/prometheus` - Prometheus metrics
- `/actuator/health` - Health check

## License

This project is licensed under the Apache Open License.
```
