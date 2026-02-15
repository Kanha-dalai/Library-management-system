# 📚 Library Management System (Java + JDBC)

## 📌 Project Description

This is a simple console-based Library Management System developed using Java and JDBC.  
It allows users to:

- Add multiple books (Batch Insert)
- View all books
- Issue a book
- Return a book

The project demonstrates:

- JDBC connectivity
- Batch Processing
- Transaction Management (Commit & Rollback)
- try-with-resources
- Exception Handling
- Basic OOP concepts

Database Name is : library
CREATE DATABASE library;
USE library;

table 1 : books
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    quantity INT
);

table 2 : issue
CREATE TABLE issue (
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    issue_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(id)
);

---

## 🛠 Technologies Used

- Java
- JDBC
- MySQL
- MySQL Connector JAR

---
