# Proyecto General: Gestión de Comerciantes y Establecimientos

## Tabla de Contenidos

- [Visión General](#visión-general)
- [Arquitectura del Proyecto](#arquitectura-del-proyecto)
- [Base de Datos](#base-de-datos)
- [Backend](#backend)
- [Frontend](#frontend)
- [Resolución de los Retos](#resolución-de-los-retos)
- [Configuración y Ejecución](#configuración-y-ejecución)

---

## Visión General

Este proyecto permite gestionar comerciantes y sus establecimientos mediante un sistema basado en tres capas:

1. **Base de Datos**: Oracle para el almacenamiento de datos.
2. **Backend**: Spring Boot con Java, que expone una API REST.
3. **Frontend**: React con TypeScript para la interfaz de usuario.

Incluye funcionalidades como autenticación, operaciones CRUD para comerciantes y establecimientos, y generación de reportes en formatos CSV y PDF.

---

## Arquitectura del Proyecto

La arquitectura sigue el patrón de capas:

1. **Base de Datos**:
   - Tablas para `users`, `comerciantes` y `establecimientos`.
   - Procedimientos almacenados para algunas operaciones.
2. **Backend**:
   - Controladores para endpoints REST.
   - Servicios para la lógica de negocio.
   - Repositorios para interactuar con la base de datos mediante JPA.
   - Swagger para documentación interactiva.
3. **Frontend**:
   - Páginas y componentes en React para visualizar y gestionar datos.
   - Servicios para consumir la API REST del backend.
   - Navegación entre módulos mediante React Router.

---

## Base de Datos

### Tablas Principales

1. **Tabla `users`**:
   - Almacena información de usuarios para autenticación y roles.
   - Incluye una secuencia `USER_SEQ` para generar IDs.

2. **Tabla `comerciantes`**:
   - Almacena información de los comerciantes, como nombre, ubicación y estado.
   - Relacionada con `users` para auditoría.

3. **Tabla `establecimientos`**:
   - Contiene los establecimientos asociados a comerciantes.
   - Relacionada con `comerciantes` mediante una clave foránea.

### Secuencias

- **`USER_SEQ`**: Para IDs de usuarios.
- **`COMERCIANTE_SEQ`**: Para IDs de comerciantes.
- **`ESTABLECIMIENTO_SEQ`**: Para IDs de establecimientos.

### Procedimientos Almacenados

- Procedimiento para listar comerciantes.
- Procedimiento para generar reportes personalizados.

---

## Backend

### Tecnologías Utilizadas

- **Java 17**
- **Spring Boot** (Web, Data JPA, Security)
- **JasperReports** para la generación de PDFs.
- **Swagger** para documentar la API REST.
- **Docker** para contenerizar la aplicación.

### Endpoints

#### Autenticación

- **POST /auth/login**: Autenticación de usuarios con JWT.

#### Comerciantes

- **GET /comerciantes**: Listar comerciantes con paginación y filtros.
- **POST /comerciantes**: Crear un comerciante.
- **GET /comerciantes/{id}**: Consultar un comerciante.
- **DELETE /comerciantes/{id}**: Eliminar un comerciante.

#### Establecimientos

- **GET /establecimientos/comerciante/{id}**: Listar establecimientos por comerciante.
- **POST /establecimientos**: Crear un establecimiento.
- **DELETE /establecimientos/{id}**: Eliminar un establecimiento.

#### Reportes

- **GET /reporte/pdf/{id}**: Generar un reporte PDF de un comerciante.
- **GET /reporte/csv**: Generar un reporte CSV con todos los comerciantes.

---

## Frontend

### Tecnologías Utilizadas

- **React 18**
- **TypeScript**
- **Vite**
- **Material-UI**
- **Axios**

### Componentes Principales

1. **LoginPage**:
   - Inicio de sesión para obtener el token JWT.
2. **ComerciantePage**:
   - Lista comerciantes en una tabla.
   - Incluye botón para descargar reportes.
3. **EstablecimientoPage**:
   - Lista establecimientos vinculados a un comerciante.
4. **Navbar**:
   - Navegación entre módulos.

---

## Resolución de los Retos

1. **Autenticación (Reto 6)**:
   - Implementada con JWT en el backend.
   - Componente `LoginPage` en el frontend.

2. **Listas de Valores (Reto 7)**:
   - Backend devuelve departamentos y municipios.

3. **CRUD de Comerciantes (Reto 8)**:
   - Endpoints para crear, listar, consultar y eliminar comerciantes.
   - Componente `ComercianteTable` en el frontend.

4. **CRUD de Establecimientos (Reto 9)**:
   - Endpoints para gestionar establecimientos.
   - Componente `EstablecimientoTable` en el frontend.

5. **Reporte CSV (Reto 10)**:
   - Endpoint que genera un archivo CSV con todos los comerciantes.

6. **Reporte PDF (Reto 11)**:
   - Generación de reportes PDF con JasperReports.

7. **Navegación entre Módulos (Reto 12)**:
   - Implementada con `React Router Dom`.

8. **Botones de Reporte (Reto 14)**:
   - Componentes para descargar reportes desde el frontend.

---

## Configuración y Ejecución

### Backend

1. Configurar el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   ```

2. Ejecutar:

   ```bash
   mvn spring-boot:run
   ```

### Frontend

1. Instalar dependencias:

   ```bash
   npm install
   ```

2. Ejecutar en modo desarrollo:

   ```bash
   npm run dev
   ```

### Docker

1. Construir la imagen del backend:

   ```bash
   docker build -t backend-api .
   ```

2. Ejecutar el contenedor:

   ```bash
   docker run -p 8080:8080 backend-api
   
