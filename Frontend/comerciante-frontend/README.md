# Frontend para la Gestión de Comerciantes

## Tabla de Contenidos

- [Visión General](#visión-general)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación y Configuración](#instalación-y-configuración)
- [Comandos Disponibles](#comandos-disponibles)
- [Esquema de Navegación](#esquema-de-navegación)
- [Detalles de los Componentes](#detalles-de-los-componentes)

---

## Visión General

Este proyecto es la interfaz de usuario para la gestión de comerciantes y establecimientos. Proporciona funcionalidades como:

- Inicio de sesión con autenticación JWT.
- Visualización de comerciantes en una tabla con información relevante.
- Visualización de establecimientos vinculados a comerciantes.
- Descarga de reportes en formato CSV y PDF.

---

## Tecnologías Utilizadas

- **React** (v18)
- **TypeScript** (v5)
- **Vite** para la configuración y compilación del proyecto.
- **React Router Dom** (v6) para la navegación entre vistas.
- **Axios** para las solicitudes HTTP al backend.
- **Material-UI (MUI)** para estilos y componentes visuales.

---

## Estructura del Proyecto

```bash
comerciante-frontend/
├── src/
│   ├── components/
│   │   ├── Navbar.tsx
│   │   ├── ComercianteTable.tsx
│   │   ├── EstablecimientoTable.tsx
│   │   └── ReportButtons.tsx
│   ├── pages/
│   │   ├── LoginPage.tsx
│   │   ├── ComerciantePage.tsx
│   │   └── EstablecimientoPage.tsx
│   ├── services/
│   │   ├── authService.ts
│   │   ├── comercianteService.ts
│   │   └── establecimientoService.ts
│   ├── App.tsx
│   ├── main.tsx
│   └── styles/
│       └── App.css
└── index.html
```

---

## Instalación y Configuración

### Prerrequisitos

1. **Node.js** instalado (v16 o superior).
2. Un backend funcional que siga la estructura descrita previamente.

### Crear el Proyecto

1. Crear el proyecto con Vite y TypeScript:

   ```bash
   npm create vite@latest comerciante-frontend --template react-ts
   cd comerciante-frontend
   ```

2. Instalar las dependencias adicionales:

   ```bash
   npm install axios react-router-dom@6 @mui/material @emotion/react @emotion/styled
   ```

### Configurar el Backend

Asegúrate de que el backend esté en ejecución y accesible desde el frontend (por defecto, en `http://localhost:8080`). Si es necesario, actualiza las URLs en los servicios.

---

## Comandos Disponibles

1. **Instalar dependencias**:

   ```bash
   npm install
   ```

2. **Ejecutar el modo desarrollo**:

   ```bash
   npm run dev
   ```

3. **Construir para producción**:

   ```bash
   npm run build
   ```

4. **Previsualizar la compilación**:

   ```bash
   npm run preview
   ```

---

## Esquema de Navegación

- **`/`**: Página de inicio de sesión.
- **`/comerciantes`**: Página para visualizar comerciantes.
- **`/establecimientos`**: Página para visualizar establecimientos asociados a un comerciante.

### Flujo General

1. El usuario inicia sesión en la página principal (`/`) ingresando su correo y contraseña.
2. Una vez autenticado, el usuario es redirigido a la página de comerciantes (`/comerciantes`).
3. El usuario puede navegar a la página de establecimientos (`/establecimientos`) para buscar y visualizar establecimientos vinculados a comerciantes.
4. Opcionalmente, puede descargar reportes en formato CSV o PDF.

---

## Detalles de los Componentes

### **Navbar**

- Archivo: `Navbar.tsx`
- Funcionalidad: Proporciona navegación entre las páginas de comerciantes y establecimientos.

### **LoginPage**

- Archivo: `LoginPage.tsx`
- Funcionalidad: Página para iniciar sesión. Al autenticar al usuario, guarda el token JWT en el almacenamiento local y redirige a la página de comerciantes.

### **ComercianteTable**

- Archivo: `ComercianteTable.tsx`
- Funcionalidad: Muestra una tabla con los comerciantes registrados, incluyendo campos como nombre, departamento, municipio y estado.

### **EstablecimientoTable**

- Archivo: `EstablecimientoTable.tsx`
- Funcionalidad: Muestra una tabla con los establecimientos asociados a un comerciante. Incluye campos como nombre, ingresos y número de empleados.

### **ReportButtons**

- Archivo: `ReportButtons.tsx`
- Funcionalidad: Proporciona botones para descargar reportes en formato CSV y PDF.

---
