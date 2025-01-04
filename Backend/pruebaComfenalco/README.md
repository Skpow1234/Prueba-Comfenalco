# Backend API para la Gestión de Comerciantes

## Tabla de Contenidos

- [Visión General](#visión-general)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Endpoints](#endpoints)
- [Documentación con Swagger](#documentación-con-swagger)
- [Ejecutar la Aplicación Localmente](#ejecutar-la-aplicación-localmente)
- [Despliegue con Docker](#despliegue-con-docker)

---

## Visión General

Este backend proporciona funcionalidades para gestionar comerciantes y sus establecimientos. Incluye autenticación de usuarios con JWT, operaciones CRUD para comerciantes y establecimientos, y generación de reportes en formatos CSV y PDF.

---

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **Swagger** para documentación de la API
- **Base de Datos Oracle** para persistencia de datos
- **JasperReports** para generación de PDFs
- **Docker** para contenerización

---

## Estructura del Proyecto

```bash
src/
├── main/
│   ├── java/
│   │   └── com/tuempresa/proyecto/
│   │       ├── controllers/
│   │       ├── dtos/
│   │       ├── entities/
│   │       ├── mappers/
│   │       ├── repositories/
│   │       ├── services/
│   │       ├── services/impl/
│   │       └── utils/
│   └── resources/
│       ├── application.properties
│       └── reports/
└── test/
```

---

## Endpoints

### Autenticación

- **POST /auth/login**: Autentica a un usuario y devuelve un JWT.

### Endpoints de Comerciantes

- **GET /comerciantes**: Recupera una lista paginada de comerciantes con filtros opcionales.
- **GET /comerciantes/{id}**: Recupera un comerciante por su ID.
- **POST /comerciantes**: Crea un nuevo comerciante.
- **DELETE /comerciantes/{id}**: Elimina un comerciante por su ID.

### Endpoints de Establecimientos

- **GET /establecimientos/comerciante/{comercianteId}**: Recupera los establecimientos asociados a un comerciante.
- **GET /establecimientos/{id}**: Recupera un establecimiento por su ID.
- **POST /establecimientos**: Crea un nuevo establecimiento.
- **DELETE /establecimientos/{id}**: Elimina un establecimiento por su ID.

### Endpoints de Reportes

- **GET /reporte/pdf/{comercianteId}**: Genera un reporte PDF con los datos de un comerciante.
- **GET /reporte/csv**: Genera un reporte CSV con todos los comerciantes registrados.

---

## Documentación con Swagger

La API utiliza Swagger para documentación y pruebas. Puedes acceder a ella en:

```bash
http://localhost:8080/swagger-ui.html
```

---

## Ejecutar la Aplicación Localmente

### Requisitos Previos

1. **Java 17** instalado.
2. **Base de Datos Oracle** en ejecución local o remota.
3. Maven instalado para la gestión de dependencias.

### Pasos

1. Configura la base de datos en `src/main/resources/application.properties`:

   ```bash
    properties
   spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
   spring.jpa.hibernate.ddl-auto=update
   ```

2. Construye y ejecuta la aplicación:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## Despliegue con Docker

### Dockerfile

```Dockerfile
# Imagen base de Java
FROM openjdk:17-jdk-slim

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/proyecto-1.0.0.jar app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Construir y Ejecutar el Contenedor Docker

1. Construye la imagen Docker:

   ```bash
   docker build -t proyecto-api .
   ```

2. Ejecuta el contenedor:

   ```bash
   docker run -p 8080:8080 proyecto-api
   ```

---
