# Issue Tracker API (Spring Boot)

A clean, ATS-friendly backend project you can push to GitHub.

## Features
- JWT Authentication (Register/Login)
- Roles: USER, ADMIN
- Issue CRUD + Assignment + Status updates
- Filters + Pagination + Sorting
- Swagger UI (OpenAPI)
- Validation + Global error handling
- Docker + Docker Compose (App + PostgreSQL)
- Basic Tests (JUnit)

## Tech
- Java 17
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Docker

---

## Run locally (without Docker)
1. Create a PostgreSQL DB and update `application.yml`.
2. Run:
```bash
mvn spring-boot:run
```

## Run with Docker
```bash
docker compose up --build
```

Swagger UI:
- http://localhost:8080/swagger-ui/index.html

---

## API Quick Start
### Register
`POST /api/auth/register`

### Login
`POST /api/auth/login`

Copy `accessToken` and use in Swagger:
```
Authorization: Bearer <token>
```

---

## Suggested GitHub repo name
`issue-tracker-api-springboot`
