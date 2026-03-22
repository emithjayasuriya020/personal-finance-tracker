# 💰 Personal Finance Tracker

> **Note:** This is an old coursework project built as part of my academic studies.

A web-based personal finance tracking application built with **Spring Boot**, **Thymeleaf**, and **MySQL**. It allows users to manage their income and expenses, organize transactions by category, and view a financial summary on a dashboard.

---

## 🛠️ Tech Stack

- **Backend:** Java 22, Spring Boot 3.3.3
- **Frontend:** Thymeleaf, HTML, CSS
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Validation:** Jakarta Bean Validation
- **Build Tool:** Gradle

---

## ✨ Features

- 📊 **Dashboard** — View total income, total expenses, and recent transactions at a glance
- 💸 **Transaction Management** — Add, edit, and delete income/expense transactions
- 🗂️ **Category Management** — Create and manage custom categories for INCOME and EXPENSE types
- 👤 **User Management** — Register and log in as a user

---

## 🗄️ Database Schema

The application uses three core entities:

| Entity | Fields |
|---|---|
| `Transaction` | id, description, amount, transactionDate, type, category |
| `Category` | id, name, type (INCOME / EXPENSE) |
| `User` | id, username, password, email |

---

## 🚀 Getting Started

### Prerequisites

- Java 22+
- MySQL 8+
- Gradle

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/personal-finance-tracker.git
   cd personal-finance-tracker
   ```

2. **Create the database**
   ```sql
   CREATE DATABASE personal_finance_tracker;
   ```

3. **Configure `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/personal_finance_tracker
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

5. **Visit** `http://localhost:8080`

---

## 📁 Project Structure

```
src/main/java/com/example/personal_finance_tracker/
├── controller/
│   ├── DashboardController.java
│   ├── TransactionController.java
│   ├── CategoryController.java
│   └── UserController.java
├── service/
│   ├── TransactionService.java
│   ├── CategoryService.java
│   └── UserService.java
├── repository/
│   ├── TransactionRepository.java
│   ├── CategoryRepository.java
│   └── UserRepository.java
├── model/
│   ├── Transaction.java
│   ├── Category.java
│   ├── User.java
│   └── TransactionType.java (enum)
└── config/
    └── WebConfig.java
```

---

## ⚠️ Known Limitations

Since this was a coursework project focused on learning Spring Boot fundamentals, it has some limitations that would need to be addressed in a production app:

- Passwords are stored in plain text (no hashing)
- No Spring Security — routes are not protected after login
- No user-to-transaction ownership — all users share the same transaction data
- Income/expense totals are computed in-memory rather than via database queries

---

## 📚 Purpose

This project was developed as coursework to learn and demonstrate:
- Spring Boot MVC architecture
- Spring Data JPA and database integration
- Thymeleaf server-side rendering
- Bean Validation
- Basic CRUD operations in a web application
