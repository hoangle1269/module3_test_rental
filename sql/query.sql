CREATE DATABASE rental_management_system;

use rental_management_system;

CREATE TABLE rentals (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         rental_code VARCHAR(20) UNIQUE NOT NULL,
                         status ENUM('Empty', 'Util', 'Full') NOT NULL,
                         area FLOAT NOT NULL,
                         floor INT NOT NULL,
                         rental_type ENUM('Share office', 'Full office') NOT NULL,
                         price DECIMAL(15, 2) NOT NULL,
                         start_date DATE NOT NULL,
                         end_date DATE NOT NULL
);

INSERT INTO rentals (rental_code, status, area, floor, rental_type, price, start_date, end_date)
VALUES
    ('ABC-01-01', 'Empty', 25.5, 5, 'Share office', 1500000.00, '2024-08-10', '2025-02-10'),
    ('DEF-02-02', 'Util', 30.0, 10, 'Full office', 2500000.00, '2024-09-01', '2025-03-01');


select * from rentals;