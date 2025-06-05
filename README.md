# 🏥 Hospital Management API

Este proyecto es una API REST desarrollada en Spring Boot para gestionar un sistema de médicos y pacientes de un hospital distribuido en varias ciudades. Permite consultar información de empleados (doctores) y pacientes, incluyendo búsquedas filtradas por departamento, estado, fecha de nacimiento y más.

---

## 🛠 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (para pruebas en memoria)
- Lombok (opcional)
- Maven

---

## 📁 Estructura del proyecto

```

com.example.hospital
├── enums
│   └── EmployeeStatus.java
├── models
│   ├── Employee.java
│   └── Patient.java
├── repositories
│   ├── EmployeeRepository.java
│   └── PatientRepository.java
├── controllers
│   ├── EmployeeController.java
│   └── PatientController.java
└── HospitalApplication.java

````

---

## 🧪 Datos de ejemplo (se cargan automáticamente)

```sql
-- Empleados
INSERT INTO EMPLOYEE (employee_id, department, name, status) VALUES
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
(564134, 'immunology', 'Sam Ortega', 'ON'),
(761527, 'cardiology', 'German Ruiz', 'OFF'),
(166552, 'pulmonary', 'Maria Lin', 'ON'),
(156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
(172456, 'psychiatric', 'John Paul Armes', 'OFF');

-- Pacientes
INSERT INTO PATIENT (name, date_of_birth, admitted_by) VALUES
('Jaime Jordan', '1984-03-02', 564134),
('Marian Garcia', '1972-01-12', 564134),
('Julia Dusterdieck', '1954-06-11', 356712),
('Steve McDuck', '1931-11-10', 761527),
('Marian Garcia', '1999-02-15', 172456);
````

---

## 📌 Endpoints disponibles

### 🔹 Empleados

* `GET /employees`
  Obtener todos los empleados.

* `GET /employees/{id}`
  Obtener un empleado por su ID.

* `GET /employees/status/{status}`
  Filtrar empleados por estado (`ON`, `OFF`, `ON_CALL`).

* `GET /employees/department/{department}`
  Filtrar empleados por departamento.

---

### 🔹 Pacientes

* `GET /patients`
  Obtener todos los pacientes.

* `GET /patients/{id}`
  Obtener un paciente por su ID.

* `GET /patients/dob?start=yyyy-MM-dd&end=yyyy-MM-dd`
  Filtrar pacientes por rango de fecha de nacimiento.

* `GET /patients/department/{department}`
  Obtener pacientes ingresados por doctores de un departamento específico.

* `GET /patients/doctor-status/{status}`
  Obtener pacientes cuyo médico tiene un estado específico (`OFF`, `ON`, etc.).

---

## ⚙️ Configuración H2 y propiedades

`src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:hospital
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

Para acceder a la consola H2:
👉 `http://localhost:8080/h2-console`
Usa `jdbc:h2:mem:hospital` como URL de conexión.

---

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio (o haz `fork` si estás en un ejercicio de clase).
2. Abre el proyecto en tu IDE favorito (VS Code, IntelliJ...).
3. Asegúrate de tener Java y Maven instalados.
4. Ejecuta la clase `HospitalApplication`.
5. Accede a `http://localhost:8080` y prueba los endpoints con Postman o navegador.

---

## 📌 Notas

* Si este ejercicio es parte de una entrega, asegúrate de hacer **pull request** desde tu fork.
* Puedes usar `curl`, Postman o un cliente frontend para probar los endpoints.

---

## 🧑‍⚕️ Autor/a

Hecho con cariño por **Mábel Martínez** como parte del curso de backend con Java y Spring de Ironhack.
