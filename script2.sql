CREATE TABLE Employee (
employee_id INT,
department VARCHAR(255),
name VARCHAR(255),
status VARCHAR(255),
PRIMARY KEY (employee_id)
);

CREATE TABLE Patient (
patient_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
date_of_birth INT,
admitted_by INT FOREIGN KEY (Employee)
PRIMARY KEY (patient_id)
);

INSERT INTO Employee (employee_id, department, name, status ) VALUES 
(356712, "cardiology", "Alonso Flores", "ON_CALL");
(564134,"immunology", "Sam Ortega", "ON");
(761527,"cardiology", "German Ruiz", "OFF");
(166552, "pulmonary", "Maria Lin", "ON");
(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
(172456, "psychiatric", "John Paul Armes", "OFF");

INSERT INTO Patient (name, dathe_of_birth, admited_by) VALUES ,
("Jaime Jordan", 1984-03-02, 564134 );
("Marian Garcia", 1972-01-12, 564134);
("Julia Dusterdieck", 1954-06-11, 356712);
("Steve McDuck", 1931-11-10, 761527);
("Marian Garcia", 1999-02-15, 172456);

SELECT * FROM employee WHERE department;
SELECT * FROM employee WHERE employee_id;
SELECT * FROM employee WHERE status;
SELECT * FROM employee WHERE department;
SELECT * FROM patient;
SELECT * FROM patient WHERE patient_id;
SELECT * FROM patient WHERE date_of_birth BETWEEN ? AND ?;
SELECT p.* FROM patient p
JOIN employee e ON p.admitted_by = e.employee_id;
WHERE e.department = ?;
SELECT p.* FROM patient p
JOIN employee e ON p.admitted_by = e.employee_id;
WHERE e.status;
