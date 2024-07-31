
CREATE DATABASE doctor_db;

USE doctor_db;


CREATE TABLE employee (
                          employee_id INT PRIMARY KEY,
                          department VARCHAR(50),
                          name VARCHAR(50),
                          status VARCHAR(10)
);

CREATE TABLE patient (
                         patient_id INT PRIMARY KEY,
                         name VARCHAR(50),
                         date_of_birth DATE,
                         admitted_by INT,
                         FOREIGN KEY (admitted_by) REFERENCES employee(employee_id)
);


INSERT INTO employee (employee_id, department, name, status)
VALUES
    (356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
    (564134, 'immunology', 'Sam Ortega', 'ON'),
    (761527, 'cardiology', 'German Ruiz', 'OFF'),
    (166552, 'pulmonary', 'Maria Lin', 'ON'),
    (156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
    (172456, 'psychiatric', 'John Paul Armes', 'OFF'
    );


INSERT INTO patient (patient_id, name, date_of_birth, admitted_by)
VALUES
    (1, 'Jaime Jordan', '1984-03-02', 564134),
    (2, 'Marian Garcia', '1972-01-12', 564134),
    (3, 'Julia Dusterdieck', '1954-06-11', 356712),
    (4, 'Steve McDuck', '1931-11-10', 761527),
    (5, 'Marian Garcia', '1999-02-15', 172456
    );


SELECT * FROM employee;

#Get doctor by ID:
SELECT * FROM employee WHERE employee_id = 564134;

#Get doctors by status
SELECT * FROM employee WHERE status = status;

#Get doctors by department
SELECT * FROM employee WHERE department = department;

#Get all patients:
SELECT * FROM patient;

#Get patient by ID
SELECT * FROM patient WHERE patient_id = 2;

#Get patients by date of birth range
SELECT * FROM patient WHERE date_of_birth BETWEEN 1931-11-10 AND 1999-02-15;

#Get patients by admitting doctor's department
SELECT p.* FROM patient p
                    JOIN employee e
                         ON p.admitted_by = e.employee_id
WHERE e.department = 'cardiology';

#Get all patients with a doctor whose status is OFF
SELECT p.* FROM patient p
                    JOIN employee e
                         ON p.admitted_by = e.employee_id
WHERE e.status = 'OFF';