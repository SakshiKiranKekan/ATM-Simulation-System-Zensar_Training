CREATE DATABASE atm_system;
USE atm_system;

CREATE TABLE accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    account_holder VARCHAR(100) NOT NULL,
    pin VARCHAR(4) NOT NULL,
    balance DOUBLE DEFAULT 0.0
);

INSERT INTO accounts VALUES 
('1234567890', 'John Doe', '1234', 5000.00),
('0987654321', 'Jane Smith', '4321', 7500.00),
('1122334455', 'Alice Johnson', '1111', 3000.00);
