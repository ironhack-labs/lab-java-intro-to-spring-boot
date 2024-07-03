DROP SCHEMA IF EXISTS patient;
CREATE SCHEMA patient;
USE patient;

CREATE TABLE employee (
	employee_id INT,
    department VARCHAR(255),
	name VARCHAR(255),
    status VARCHAR(255),
	PRIMARY KEY (employee_id)
);

CREATE TABLE patient (
	patient_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	date_of_birth VARCHAR(255),
	admitted_by INT,
	PRIMARY KEY (patient_id),
	FOREIGN KEY (admitted_by) REFERENCES employee(employee_id)
);
INSERT INTO employee (employee_id, department, name, status) VALUES
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL' ),
(564134, 'immunology', 'Sam Ortega', 'ON' ),
(761527, 'cardiology', 'German Ruiz', 'OFF' ),
(166552, 'pulmonary', 'Maria Lin', 'ON' ),
(156545, 'orthopedic', 'Paolo Rodriguez', 'ON_CALL' ),
(172456,'psychiatric', 'John Paul Armes', 'OFF' );


INSERT INTO patient (name, date_of_birth, admitted_by) VALUES 
('Jaime Jordan', '1984-03-02', 564134 ),
('Marian Garcia', '1972-01-12', 564134),
('Julia Dusterdieck', '1954-06-11', 356712 ),
('Steve McDuck', '1931-11-10', 761527 ),
('Marian Garcia', '1999-02-15', 172456 );

SELECT * FROM employee;
SELECT * FROM patient;