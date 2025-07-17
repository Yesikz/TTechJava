# API de Productos - Proyecto Final

Este proyecto es una **API REST de productos** desarrollada con **Spring Boot**.  
Permite gestionar un catálogo de productos para un negocio, por ejemplo una tienda de manicura o belleza.

---

## 🛠️ Tecnologías usadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Insomnia o Postman** (para pruebas)

---

## 🚀 Funcionalidades de la API

- **Crear productos**
- **Listar productos**
- **Buscar productos por nombre**
- **Buscar producto por ID**
- **Actualizar productos**
- **Eliminar productos**

---
| Método     | Endpoint                       | Descripción                |
| ---------- | ------------------------------ | ---------------------------|
| **POST**   | `/productos`                   | Crear un producto          |
| **GET**    | `/productos`                   | Listar todos los productos |
| **GET**    | `/productos/buscar?nombre=xxx` | Buscar por nombre          |
| **GET**    | `/productos/{id}`              | Buscar por ID              |        
| **PUT**    | `/productos/{id}`              | Actualizar un producto     |
| **DELETE** | `/productos/{id}`              | Eliminar un producto       |




