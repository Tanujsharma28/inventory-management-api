# Enterprise Inventory Management API

A **Spring Boot based RESTful backend application** for managing products, orders, categories, and users in an inventory system.

This project demonstrates **enterprise-level backend architecture** including layered design, DTO pattern, validation, pagination, sorting, logging, and API documentation.

---

# 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger (OpenAPI)
* Spring Boot Actuator
* Git & GitHub

---

# 📦 Features

### Product Management

* Create Product
* Get All Products
* Get Product by ID
* Update Product
* Delete Product

### Advanced Features

* Pagination
* Sorting
* DTO Pattern
* Mapper Layer
* Validation
* Global Exception Handling
* Logging
* Swagger API Documentation
* Actuator Monitoring

---

# 🏗 Project Architecture

Client Request
↓
Controller Layer
↓
Service Layer
↓
Repository Layer
↓
JPA / Hibernate
↓
MySQL Database

---

# 📂 Project Structure

src/main/java/com/enterprise/inventory

controller → REST APIs
service → Business Logic
service/impl → Service Implementations
repository → Database Layer
model → Entity Classes
dto → Data Transfer Objects
mapper → DTO ↔ Entity Conversion
exception → Custom Exceptions
util → Utility Classes

---

# 🔗 API Endpoints

### Create Product

POST /api/products

### Get All Products

GET /api/products

### Get Product By ID

GET /api/products/{id}

### Pagination

GET /api/products/paged?page=0&size=5

### Sorting

GET /api/products/sorted?page=0&size=5&sortBy=price

---

# 📊 Swagger API Documentation

Access Swagger UI:

http://localhost:8080/swagger-ui/index.html

---

# 📈 Actuator Monitoring

Check application health:

http://localhost:8080/actuator/health

---

# ▶️ How to Run the Project

1. Clone the repository

git clone https://github.com/yourusername/inventory-management-api.git

2. Navigate to the project directory

cd inventory-management-api

3. Run the application

mvn spring-boot:run

---

# 🧠 Learning Highlights

This project demonstrates:

* REST API development
* Layered architecture
* DTO and Mapper patterns
* Validation and exception handling
* Pagination and sorting
* API documentation using Swagger
* Application monitoring using Actuator

---

# 👨‍💻 Author

Built by **Tanuj Sharma**
