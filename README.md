# Multi-Tenant Employee Management Platform (MTEP)

An Enterprise-Grade Multi-Tenant Employee Management System built using Spring Boot, Spring Security, JWT Authentication, and MySQL for secure company-wise employee management.

![Multi Tenant](https://img.shields.io/badge/MULTI--TENANT-0078D7?style=flat-square)
![Employee Management](https://img.shields.io/badge/EMPLOYEE%20MANAGEMENT-555555?style=flat-square)
![Spring Boot](https://img.shields.io/badge/SPRING%20BOOT-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/SPRING%20SECURITY-6DB33F?style=flat-square)
![JWT Authentication](https://img.shields.io/badge/JWT%20AUTHENTICATION-FF6600?style=flat-square)
![REST API](https://img.shields.io/badge/REST%20API-555555?style=flat-square)
![Role Based Access](https://img.shields.io/badge/ROLE%20BASED%20ACCESS-9B30FF?style=flat-square)
![MySQL](https://img.shields.io/badge/MYSQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/SWAGGER%20OPENAPI-85EA2D?style=flat-square)
![Java](https://img.shields.io/badge/JAVA%2017-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/MAVEN-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/STATUS-IN%20DEVELOPMENT-brightgreen?style=flat-square)

---

## Overview

Multi-Tenant Employee Platform (MTEP) is a secure Employee Management System that allows multiple companies (tenants) to manage their employees independently within a single application.

The platform automatically associates employees with their respective company using JWT-based authentication and tenant isolation mechanisms.

This system focuses on:

- Secure Multi-Tenant Architecture
- Employee Lifecycle Management
- JWT Authentication & Authorization
- Data Isolation Between Companies
- Scalable REST APIs
- Enterprise Security Best Practices

into a single scalable backend platform.

---

## Key Features

**Multi-Tenant Architecture**
- Multiple companies can use the same application
- Complete data isolation between tenants
- Automatic tenant identification from logged-in user
- Secure company-specific employee management

**Authentication & Security**
- Company Registration & Admin Login
- JWT Token Authentication
- Spring Security Integration
- Password Encryption using BCrypt
- Role-Based Authorization (COMPANY_ADMIN)

**Employee Management**
- Create, View, Update & Delete Employees
- Active / Inactive Employee Status Management

**Validation & Exception Handling**
- Email & Password Strength Validation
- Global Exception Handling
- Custom Exception Responses
- Input Validation using Jakarta Validation

**API Documentation**
- Swagger UI Integration
- OpenAPI Documentation
- Interactive API Testing

---

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Backend Development |
| Spring Boot 3 | Application Framework |
| Spring Security | Authentication & Authorization |
| JWT | Secure Token Authentication |
| Spring Data JPA | ORM Layer |
| Hibernate | Persistence Framework |
| MySQL | Database |
| Swagger OpenAPI | API Documentation |
| Maven | Dependency Management |
| BCrypt | Password Encryption |

---

## Project Architecture

```
src/main/java/com/vsk/mtep
│
├── controller
│   ├── AuthController
│   └── EmployeeController
│
├── dto
│   ├── LoginRequest
│   ├── LoginResponse
│   └── RegisterRequest
│
├── entity
│   ├── User
│   ├── Tenant
│   └── Employee
│
├── repository
│   ├── UserRepository
│   ├── TenantRepository
│   └── EmployeeRepository
│
├── security
│   ├── JwtUtil
│   ├── JwtFilter
│   └── SecurityConfig
│
├── service
├── service_impl
├── exception
└── config
```

---

## System Workflow

1. Company Admin registers a company
2. Company information is stored as a Tenant
3. Admin logs in using email and password
4. JWT Token is generated
5. Token is passed in Authorization Header
6. Employee is created
7. System automatically identifies tenant from JWT
8. Employee is linked to the correct company
9. Each company can access only its own employees

---

## API Endpoints

### Register Company
`POST /api/auth/register`

Request
```json
{
  "companyName": "VSK Technologies",
  "adminName": "Sujith",
  "adminEmail": "sujith@gmail.com",
  "password": "Password123",
  "confirmPassword": "Password123"
}
```

Response
```text
Company registered successfully
```

---

### Login
`POST /api/auth/login`

Request
```json
{
  "email": "sujith@gmail.com",
  "password": "Password123"
}
```

Response
```json
{
  "token": "JWT_TOKEN"
}
```

---

### Create Employee
`POST /api/employees`

Header
```text
Authorization: Bearer JWT_TOKEN
```

Request
```json
{
  "name": "John",
  "email": "john@gmail.com",
  "department": "IT",
  "salary": 50000,
  "active": true
}
```

---

### Get Employees
`GET /api/employees`

Header
```text
Authorization: Bearer JWT_TOKEN
```

---

### Update Employee
`PUT /api/employees/{id}`

---

### Delete Employee
`DELETE /api/employees/{id}`

---


## Database Configuration

`application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mtep
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Installation & Setup

**Step 1 — Clone Repository**
```bash
git clone https://github.com/vsk-91/mtep.git
```

**Step 2 — Navigate to Project**
```bash
cd mtep
```

**Step 3 — Install Dependencies**
```bash
mvn clean install
```

**Step 4 — Run Application**
```bash
mvn spring-boot:run
```

Application runs at:
```text
http://localhost:8080
```

---

## Security Features

- JWT Authentication
- BCrypt Password Encryption
- Spring Security Filters
- Tenant-Based Data Isolation
- Role-Based Access Control
- Validation & Exception Handling

---

## Future Enhancements

- Pagination & Sorting
- Employee Search Filters
- User Roles (ADMIN / USER / HR)
- Audit Logs
- Email Notifications
- Docker Deployment
- Kubernetes Support
- AWS Deployment
- Employee Attendance Module
- Payroll Management Module

---

## Learning Outcomes

Through this project, the following concepts were implemented:

- Spring Boot REST APIs
- Spring Security & JWT Authentication
- Multi-Tenant Architecture
- JPA & Hibernate
- MySQL Integration
- Swagger Documentation
- Validation & Exception Handling
- Role-Based Authorization
- Enterprise Backend Development

---

## Connect

- GitHub: https://github.com/vsk-91
- LinkedIn: https://linkedin.com/in/vsk-sujith-46069528b

---

## Conclusion

MTEP is a backend project I built to explore how real-world enterprise applications handle multiple clients on a single platform. The idea was simple — let different companies sign up, manage their own employees, and never see each other's data.

Building this helped me understand how JWT authentication works beyond just login, how tenant isolation is implemented at the data level, and how Spring Security ties everything together in a structured way.

