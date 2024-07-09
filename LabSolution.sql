# exercise 1
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


# exercise 3
SELECT * FROM employee;

# exercise 4
SELECT * FROM employee WHERE employee_id = 172456;

# exercise 5
SELECT * FROM employee WHERE status = status;

# exercise 6
SELECT * FROM employee WHERE department = department;

# exercise 7
SELECT * FROM patient;


SELECT * FROM patient WHERE patient_id = 1;


SELECT * FROM patient WHERE date_of_birth BETWEEN 1931-11-10 AND 1999-02-15;


SELECT p.* FROM patient p
JOIN employee e
ON p.admitted_by = e.employee_id
WHERE e.department = 'cardiology';


SELECT p.* FROM patient p
JOIN employee e
ON p.admitted_by = e.employee_id
WHERE e.status = 'OFF';


