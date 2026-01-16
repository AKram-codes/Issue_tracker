# Issue Tracker API 🚀

A production-style **Issue Tracker Backend API** built using **Java + Spring Boot 3**, featuring **JWT authentication**, **role-based access control**, and **issue management** with filtering and pagination.  
This project follows clean backend architecture practices and is designed to be scalable, secure, and easy to deploy.

---

## ✨ Features

- ✅ User Registration & Login (JWT Authentication)
- ✅ Role-Based Access Control (**ADMIN**, **USER**)
- ✅ Issue Management (Create / Update / Delete / View)
- ✅ Issue Status & Priority handling
- ✅ Pagination & Filtering Support
- ✅ Swagger/OpenAPI Documentation
- ✅ PostgreSQL Database Integration
- ✅ Docker + Docker Compose Setup
- ✅ Basic Unit Tests (JUnit)

---

## 🏗️ Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3
- **Security:** Spring Security + JWT
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **API Docs:** Swagger / OpenAPI
- **Containerization:** Docker, Docker Compose
- **Testing:** JUnit 5

---

## 📂 Project Structure

````bash
issue-tracker/
│── src/main/java/com/yourpackage/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── dto/
│   ├── entity/
│   ├── security/
│   └── config/
│── src/main/resources/
│   ├── application.yml
│   └── db/migration/
│── docker-compose.yml
│── Dockerfile
│── pom.xml
└── README.md


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
````

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

# `issue-tracker-api-springboot`

# Issue_tracker

enterprise-style backend project with authentication + role-based access (real industry) and CRUD + pagination + validation testing and API documentation
