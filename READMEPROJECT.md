# Hospital Management API (Spring Boot)

Este proyecto es una API REST creada con **Spring Boot** para gestionar doctores y pacientes en un hospital. Permite realizar operaciones CRUD y realizar consultas avanzadas.

## Características
- Gestión de Doctores (Empleados): Crear, leer, actualizar y eliminar.
- Gestión de Pacientes: Crear, leer, actualizar y eliminar.
- Filtros avanzados: Buscar por estado del doctor, departamento, o por rango de fechas de nacimiento.

## Requisitos
- **Java 17** o superior
- **Maven**
- **IDE**: IntelliJ, Eclipse, VS Code, etc.

## Instalación y Ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/hospital-management.git
   cd hospital-management

2. **Ejecutar la aplicación con Maven:**:

- **mvn spring-boot:run**

3. **Base de datos H2**
- **La base de datos es en memoria y se configura automáticamente.**
- **Acceso a consola: http://localhost:8080/h2-console.**
- **Credenciales:**
   - **URL: jdbc:h2:mem:testdb**
   - **Usuario: sa (sin contraseña).**

# Endpoints

## Doctores

**Obtener los doctores**
- **GET /api/employees**
**Obtener doctor por ID:**
- **GET /api/employees/{id}**
**Obtener doctores por estado (ON_CALL, ON, OFF):**
- **GET /api/employees/status/{status}**
**Obtener doctores por departamento:**
- **GET /api/employees/department/{department}**

## Pacientes

**Obtener todos los pacientes**
- **GET /api/patients**
  **Pacientes por rango de fechas (start, end):**
- **GET /api/patients/dob?start=YYYY-MM-DD&end=YYYY-MM-DD**
  **Pacientes por departamento del doctor:**
- **GET /api/patients/doctor/department/{department}**
  **Pacientes con doctor OFF**
- **GET /api/patients/doctor/status/OFF**

# Ejemplo de uso

1. **Obtener los doctores**
- **GET http://localhost:8080/api/employees**
2. **Obtener pacientes por rango de fecha**
- **GET http://localhost:8080/api/patients/dob?start=1980-01-01&end=2000-12-31**
- **[
  {
  "patientId": 1,
  "name": "Jaime Jordan",
  "dateOfBirth": "1984-03-02",
  "admittedBy": {
  "employeeId": 2,
  "name": "Dr. Sam Ortega",
  "department": "Immunology",
  "status": "ON"
  }
  }
  ]**
