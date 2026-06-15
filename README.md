# Flower Shop Inventory Management System

## Overview
This is a full-stack inventory management application built with Java and Spring Boot. It provides a web-based interface for managing flower shop products, parts, and inventory levels, including validation rules and purchase functionality.

The project demonstrates object-oriented programming, MVC architecture, form validation, and basic e-commerce workflow implementation.

---

## Features

- Web-based inventory management system
- Add, update, and delete products and parts
- Distinguish between in-house and outsourced parts
- Inventory tracking with minimum and maximum constraints
- “Buy Now” functionality that reduces stock in real time
- Input validation with error handling
- Navigation between Home and About pages
- Styled UI using custom CSS

---

## Tech Stack

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- HTML / CSS
- Maven

---

## Key Functionality

### Inventory System
- Manage flower products and component parts
- Track stock levels with constraints (min/max inventory rules)

### Validation
- Prevent inventory from exceeding max stock
- Prevent inventory from dropping below minimum stock
- Error messages displayed in UI for invalid operations

### Purchase Flow
- Users can “Buy Now” products
- Inventory automatically updates after purchase
- Displays success or error page depending on availability

### UI Pages
- Main inventory dashboard
- About page
- Success and error pages for transactions

---

## Architecture

This application follows the MVC pattern:

- **Model**: Product, Part, InhousePart, OutsourcedPart
- **View**: Thymeleaf templates (HTML pages)
- **Controller**: Spring Boot controllers managing business logic

---

## How to Run

1. Clone the repository
2. Open in IntelliJ IDEA
3. Run the Spring Boot application
4. Navigate to: https://localhost:8080

---

## Learning Outcomes

This project demonstrates:
- Full-stack Java development
- Spring Boot MVC architecture
- Form validation and error handling
- Dynamic UI rendering with Thymeleaf
- Inventory and state management
