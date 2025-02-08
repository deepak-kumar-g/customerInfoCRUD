create database customer_info;


CREATE TABLE personal_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE address_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    personal_details_id INT NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    FOREIGN KEY (personal_details_id) REFERENCES personal_details(id) ON DELETE CASCADE
);

CREATE TABLE kyc_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    personal_details_id INT NOT NULL,
    document_type VARCHAR(50) NOT NULL,
    document_number VARCHAR(100) NOT NULL,
    FOREIGN KEY (personal_details_id) REFERENCES personal_details(id) ON DELETE CASCADE
);


SELECT * FROM personal_details;

SELECT * FROM address_details;

SELECT * FROM kyc_details;
