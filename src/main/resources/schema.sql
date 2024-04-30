
CREATE TABLE IF NOT EXISTS employee (
    employee_id INT,
    department VARCHAR(255),
    name VARCHAR(255),
    status VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth DATE,
    admitted_by INT REFERENCES employee(employee_id)
);