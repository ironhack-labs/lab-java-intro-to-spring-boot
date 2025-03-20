DROP SCHEMA IF EXISTS lab401;
CREATE SCHEMA lab401;
USE lab401;

CREATE TABLE employee (
	employee_id INT NOT NULL,
	departament VARCHAR(255),
	employee_name VARCHAR(255),
  	employee_status ENUM('ON_CALL','ON','OFF'),
	PRIMARY KEY (employee_id)
);

CREATE TABLE patient (
	patient_id INT NOT NULL AUTO_INCREMENT,
	date_of_birth DATE,
	patient_name VARCHAR(255),
  	admitted_by INT NOT NULL,
	PRIMARY KEY (patient_id),
	FOREIGN KEY (admitted_by) REFERENCES employee(employee_id)
);


INSERT INTO employee (employee_id,departament,employee_name,employee_status) VALUES 
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
(564134, 'immunology', 'Sam Ortega', 'ON'),
(761527, 'cardiology', 'German Ruiz', 'OFF'),
(166552, 'pulmonary', 'Maria Lin', 'ON'),
(156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
(172456, 'psychiatric', 'John Paul Armes', 'OFF');

INSERT INTO patient (date_of_birth,patient_name,admitted_by) VALUES 
('1984-03-02', 'Jaime Jordan', 564134),
('1972-01-12', 'Marian Garcia', 564134),
('1954-06-11', 'Julia Dusterdieck', 356712),
('1931-11-10', 'Steve McDuck', 761527),
('1999-02-15', '	Marian Garcia', 172456);
