---

```markdown
# Library Hexagonal Architecture

A Java + Spring Boot project implementing a **Library Management System** using the principles of **Hexagonal Architecture (Ports & Adapters)**.

---

## 📁 Project Modules

This project is structured around 4 main modules:

```
library-hexagonal/
├── domain/           # Business model (entities, value objects, specifications, services)
├── application/      # Use cases and input/output ports
├── framework/        # Input/Output adapters (REST, JPA, CLI, etc.)
└── bootstrap/        # Main application entry point and wiring configuration
```


## ⚙️ Technologies

- Java 17+
- Spring Boot 3.x
- Maven
- JPA / Hibernate
- PostgreSQL
- Lombok

---

## 🔍 Module Overview

### `domain`
Contains the **core business logic**:
- `entity/`: Domain entities like `Book` and `User`
- `vo/`: Value Objects (e.g., `ISBN`, `BookStatus`)
- `specification/`: Business rules
- `service/`: Domain services (e.g., `LoanService`)

### `application`
Defines **what the system does**:
- `usecase/`: Interfaces for application use cases (e.g., `BookManagementUseCase`)
- `port/input/`: Input ports for driving the use cases
- `port/output/`: Output ports needed to interact with the world (e.g., data storage)

### `framework`
Implements **adapters for technologies**:
- `adapter/input/`: REST controllers, CLI adapters, etc.
- `adapter/output/`: Persistence adapters (e.g., JPA repositories)
- `mapper/`: Mappers between domain and persistence/DTO models

### `bootstrap`
- Contains the `Main.java` class (entry point)
- Initializes Spring context and wires up adapters/ports

---

## 🚀 How to Run

```bash
# 1. Clone the repository
git clone https://github.com/your-username/library-hexagonal.git

# 2. Navigate into the project directory
cd library-hexagonal

# 3. Run the application
./mvnw spring-boot:run
```

---

## 🧪 Testing

```bash
./mvnw test
```

---

## 📌 Notes

- `Book` and `User` entities are stored in **separate databases**, following DDD bounded contexts.
- This project is **technology-agnostic** at its core. You can change the output adapters (e.g., swap JPA for MongoDB) without touching the domain or application layers.

---

## 📄 License

MIT

