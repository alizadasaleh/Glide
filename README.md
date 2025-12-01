# Glide

![License](https://img.shields.io/badge/license-MIT-blue)
![Version](https://img.shields.io/badge/version-1.0--SNAPSHOT-lightgrey)

**Glide** is a small Java Spring Boot microservice that provides domain features for mapping and place data (edges, obstacles, places, reviews). The project contains REST controllers, services, repositories and MapStruct mappers and uses PostgreSQL for persistence.

**Key technologies:** Spring Boot 3.x, Spring Data JPA, MapStruct, Lombok, PostgreSQL, SpringDoc OpenAPI

**Why this project is useful**
- **Modular domain features:** well-organized packages for `edge`, `obstacle`, `place`, and `review` features.
- **Production-ready stack:** Spring Boot with JPA, actuators, and tracing support.
- **OpenAPI / Swagger UI:** automatic API documentation via SpringDoc.
- **Simple local setup:** Gradle wrapper and example `application.yaml` for quick development.

**Repository layout (important paths)**
- `src/main/java/az/glide` — main application and feature packages
- `src/main/resources/application.yaml` — default configuration (DB connection, server port)
- `libs/` — local dependency jars required at build time (see notes below)

**Quick Start — Prerequisites**
- Java 17 or newer (Spring Boot 3.x requirement)
- Git
- Docker & Docker Compose (optional, recommended for local PostgreSQL)

Optional but required at runtime for the default config:
- PostgreSQL database (default config points to `jdbc:postgresql://localhost:5432/glide`)
- Local jars in `libs/` (`domain-1.0.0-plain.jar`, `exception-1.0.0-plain.jar`) — keep these files in place

**Run locally (development)**
1. Clone the repo and change directory:

```
git clone https://github.com/alizadasaleh/Glide.git
cd Glide
```

2. Ensure PostgreSQL is running and matches `src/main/resources/application.yaml`, or override properties with environment variables or a profile.

3. Build and run with the Gradle wrapper:

```
./gradlew clean build
./gradlew bootRun
```

Or run the produced jar:

```
./gradlew bootJar
java -jar build/libs/*-SNAPSHOT.jar
```

4. Health and management endpoints (if enabled): `http://localhost:8080/actuator/health`

5. OpenAPI / Swagger UI (when running): `http://localhost:8080/swagger-ui/index.html` (or `/swagger-ui.html`)

**Environment configuration**
- Default DB settings are in `src/main/resources/application.yaml`:

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/glide
    username: postgres
    password: root
```

- You can override configuration using Spring Boot profiles, environment variables, or command-line properties, e.g.

```
./gradlew bootRun --args='--spring.profiles.active=local'
java -jar build/libs/*.jar --spring.datasource.password=mysecret
```

**Running tests**

```
./gradlew test
```

**Notes & gotchas**
- The project references two local jar files in `libs/` (`domain-1.0.0-plain.jar`, `exception-1.0.0-plain.jar`). Ensure they are present before building.
- Spring Boot 3 requires Java 17+. If you see classfile errors, verify `java -version`.
- Database schema auto-update is enabled (`spring.jpa.hibernate.ddl-auto: update`) — for production consider using migrations (Flyway/Liquibase).

**Where to get help**
- Open an issue in this repository if you find a bug or need help.
- For general Spring Boot questions consult the Spring Boot reference docs: https://spring.io/projects/spring-boot

**Maintainers & Contribution**
- Maintainer: `alizadasaleh` (GitHub: `alizadasaleh`)
- Contributions: please open issues and pull requests. For larger contributions, please add a `CONTRIBUTING.md` file and link to it from here.

If you plan to contribute, please follow these guidelines:
- Keep changes focused and small.
- Add unit tests for new behavior when possible.
- Run `./gradlew check` before opening a PR.

**License**
- See the `LICENSE` file in this repository for license details.
