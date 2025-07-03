# 💰 Expense Tracker

A Java Spring Boot-based RESTful web application for tracking expenses and managing spending categories. 
The application provides APIs for creating, retrieving, updating, and deleting expense and category records.

---

## 📁 Project Structure

```
Expense-Tracker-master/
├── src/
│   ├── main/
│   │   ├── java/com/anish/expense_tracker_app/
│   │   │   ├── controller/         # REST API controllers
│   │   │   ├── dto/                # Data Transfer Objects
│   │   │   ├── entity/             # JPA entities for Expense and Category
│   │   │   ├── exceptions/         # Global exception handling
│   │   │   ├── mapper/             # Mapper classes for DTO ↔ Entity
│   │   │   ├── repository/         # Spring Data repositories
│   │   │   ├── service/            # Interfaces for business logic
│   │   │   └── service/impl/       # Service implementations
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml                        # Maven configuration
└── mvnw / mvnw.cmd                # Maven wrapper scripts
```

---

## 🚀 Features

- Add, update, and delete expense records
- Categorize expenses (e.g., Food, Travel, Bills)
- RESTful API architecture
- Layered architecture using Spring Boot best practices
- Exception handling for robust API responses

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- Lombok (for boilerplate code reduction)

---


### 1. Clone the Repository
```
git clone https://github.com/Anish-3-12/Expense-Tracker.git
cd Expense-Tracker
```

### 2. Build the Project
```
./mvnw clean install
```

### 3. Run the Application
```
./mvnw spring-boot:run
```

---

## 📌 Example Endpoints

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| GET    | `/expenses`            | Get all expenses             |
| POST   | `/expenses`            | Add a new expense            |
| PUT    | `/expenses/{id}`       | Update an expense            |
| DELETE | `/expenses/{id}`       | Delete an expense            |
| GET    | `/categories`          | List all categories          |
| POST   | `/categories`          | Create a new category        |

---

## 🧪 Running Tests

```bash
./mvnw test
```


## 👋 Final Note

Thanks for checking out this project! I hope this serves as a helpful reference or starting point for others building RESTful applications with Spring Boot. Feel free to contribute or fork it for your own use.

Happy coding! 🚀
