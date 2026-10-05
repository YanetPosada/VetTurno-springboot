# VetTurno

## Descripción

Sistema de gestión de citas veterinarias desarrollado con Spring Boot para la veterinaria Huellitas.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT
- MySQL
- JPA / Hibernate
- Swagger OpenAPI
- Maven
  
## Arquitectura

El proyecto está organizado en capas:

- Controller
- Service
- Repository
- DTO
- Security
  
## Funcionalidades

- Gestión de propietarios
- Gestión de mascotas
- Gestión de veterinarios
- Gestión de citas
- Registro de usuarios
- Inicio de sesión con JWT
- Roles ADMIN y USER
- Validaciones de negocio
- Documentación Swagger
  
## Seguridad

La aplicación implementa:

- JWT Authentication
- BCrypt Password Encoder
- Roles ADMIN y USER
- Endpoints protegidos
  
## Base de Datos

MySQL

Tablas principales:

- usuarios
- propietarios
- mascotas
- veterinarios
- citas
  
## Swagger

Documentación disponible en:

http://localhost:8080/swagger-ui/index.html

## Pruebas Realizadas

- Registro de usuarios
- Login
- Creación de propietarios
- Creación de mascotas
- Creación de veterinarios
- Creación de citas
- Consulta de citas
- Consulta por veterinario
- Validación de fechas pasadas
- Validación de horarios duplicados
- Prueba de roles ADMIN y USER
  
## Autor

Maria Yanet Posada Chavarría