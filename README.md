# 📚 Library Management System - Hexagonal Architecture
 Aplicación backend para gestión de biblioteca implementando Arquitectura Hexagonal (Ports & Adapters) con Spring Boot 3 y Java 21.

## 🌐 Tecnologías Principales
Java 21 (Corretto)

Spring Boot 3.4.4

Spring Data JPA (Hibernate 6)

H2 Database (en memoria)

Lombok

SpringDoc OpenAPI (Documentación API)

Maven

## 🏗️ Estructura del Proyecto
```bash
library-hexagonal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── library/
│   │   │           ├── domain/               # Capa de Dominio
│   │   │           │   ├── model/            # Entidades
│   │   │           │   ├── valueobject/      # Objetos de Valor
│   │   │           │   └── spec/            # Especificaciones
│   │   │           ├── application/          # Capa de Aplicación
│   │   │           │   ├── port/
│   │   │           │   │   ├── input/       # Puertos de Entrada (Casos de Uso)
│   │   │           │   │   └── output/      # Puertos de Salida (Repositorios)
│   │   │           │   └── service/         # Servicios de Aplicación
│   │   │           └── infrastructure/      # Capa de Infraestructura
│   │   │               ├── adapter/
│   │   │               │   ├── input/       # Adaptadores de Entrada (Controllers)
│   │   │               │   └── output/      # Adaptadores de Salida (Repositorios JPA)
│   │   │               └── config/          # Configuraciones
│   │   └── resources/
│   │       ├── application.properties       # Configuración
│   │       ├── schema.sql                  # Esquema SQL inicial
│   │       └── static/
│   └── test/                               # Pruebas
├── target/
├── pom.xml                                 # Configuración Maven
└── README.md                               # Este archivo

```
## 🚀 Endpoints Principales (API REST)

## 🚀 Endpoints Principales (API REST)

| Método | Endpoint                  | Descripción                |
|--------|---------------------------|----------------------------|
| POST   | /api/books                | Crear un libro             |
| GET    | /api/books/{isbn}         | Obtener un libro por ISBN  |
| GET    | /api/books                | Listar todos los libros    |
| PUT    | /api/books/{isbn}         | Actualizar un libro        |
| DELETE | /api/books/{isbn}         | Borrar un libro            |
| POST   | /api/books/{isbn}/borrow  | Prestar un libro           |
| POST   | /api/books/{isbn}/return  | Devolver un libro          |
| POST   | /api/members              | Registrar nuevo miembro    |

## 📊 Base de Datos H2 (Desarrollo)

URL Consola: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:librarydb

Usuario: sa

Contraseña: (vacía)

## 📝 Diagrama de Arquitectura

```
        +-------------------+
        |   API Consumers   |
        |  (Web, Mobile, CLI)
        +---------+---------+
                  |
        [HTTP/JSON]
                  |
        +---------v---------+
        |   Infrastructure  |
        |  (Controllers,    |
        |   Repositories)   |
        +---------+---------+
                  |
        [Port Interfaces]
                  |
        +---------v---------+
        |    Application    |
        |  (Use Cases,      |
        |   Services)       |
        +---------+---------+
                  |
        [Domain Model]
                  |
        +---------v---------+
        |      Domain       |
        |  (Entities,       |
        |   Value Objects)  |
        +-------------------+
```

