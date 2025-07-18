# API de Productos y Pedidos - Proyecto Final

Este proyecto es una **API REST** desarrollada con **Spring Boot** que permite gestionar un catálogo de productos y pedidos para un negocio, por ejemplo una tienda de manicura o belleza.



## 🛠️ Tecnologías usadas

- Java 21+
- Spring Boot
- Spring Data JPA
- H2 Database 
- Maven
- Insomnia o Postman (para pruebas)


## 🚀 Funcionalidades de la API

### Productos

- Crear productos
- Listar productos
- Buscar productos por nombre
- Buscar producto por ID
- Actualizar productos
- Eliminar productos 


### Pedidos

- Crear pedidos 
- Listar pedidos



### Productos

| Método | Endpoint                  | Descripción                  | 
|--------|---------------------------|------------------------------|
| POST   | /productos                | Crear un producto            | 
| GET    | /productos                | Listar todos los productos   | 
| GET    | /productos/buscar?nombre= | Buscar productos por nombre  | 
| GET    | /productos/{id}           | Buscar producto por ID       | 
| PUT    | /productos/{id}           | Actualizar un producto       | 
| DELETE | /productos/{id}           | Eliminar un producto         |


### Pedidos

| Método | Endpoint         | Descripción                  |
|--------|------------------|------------------------------|
| POST   | /pedidos       | Crear un pedido                |
| GET    | /pedidos       | Listar todos los pedidos       |


