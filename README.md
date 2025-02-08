# customerInfoCRUD

## CRUD Operations for Managing Company Customer Information

## Overview

This project provides a Spring Boot API to handle and process data for three key entities: **Personal Details**, **Address Details**, and **KYC (Know Your Customer)** details. The API uses JPA (Java Persistence API) for database interaction and supports CRUD operations (Create, Update, Delete) across multiple tables using a single API request.

The request DTO accepts the following data: Personal Details, Address Details, and KYC Details. The API is designed to streamline the process of adding, updating, and deleting user information across different tables in the database using JPA repositories.


## Request DTO

The request Data Transfer Object (DTO) accepts multiple types of data and is structured as follows:

```java
public class RequestDTO {
    // Personal Details
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // Address Details
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // KYC Details
    private String documentType;
    private String documentNumber;
}
```

### Fields:
1. **Personal Details:**
    - `firstName`: First name of the individual.
    - `lastName`: Last name of the individual.
    - `email`: Email address.
    - `phoneNumber`: Contact number.

2. **Address Details:**
    - `street`: Street address.
    - `city`: City of residence.
    - `state`: State of residence.
    - `zipCode`: Postal/ZIP code.

3. **KYC Details:**
    - `documentType`: Type of KYC document (e.g., Aadhar, Passport).
    - `documentNumber`: Unique identification number of the KYC document.

---

## Database Table Structures

### 1. **Personal Details Table**

| Column Name    | Data Type | Description                              |
|----------------|-----------|------------------------------------------|
| `id`           | INT       | Primary key, auto-generated              |
| `first_name`   | VARCHAR   | First name of the person                 |
| `last_name`    | VARCHAR   | Last name of the person                  |
| `email`        | VARCHAR   | Email address of the person              |
| `phone_number` | VARCHAR   | Contact number                           |



### 2. **Address Details Table**

| Column Name   | Data Type | Description                            |
|---------------|-----------|----------------------------------------|
| `id`          | INT       | Primary key, auto-generated            |
| `street`      | VARCHAR   | Street address                        |
| `city`        | VARCHAR   | City                                   |
| `state`       | VARCHAR   | State                                  |
| `zip_code`    | VARCHAR   | Postal code                            |
| `personal_details_id` | INT       | Foreign key to `personal_details` table |



### 3. **KYC Details Table**

| Column Name       | Data Type | Description                                   |
|-------------------|-----------|-----------------------------------------------|
| `id`              | INT       | Primary key, auto-generated                   |
| `document_type`   | VARCHAR   | Type of the document (e.g., Aadhar, Passport) |
| `document_number` | VARCHAR   | Document number                               |
| `personal_details_id`     | INT       | Foreign key to `personal_details` table       |



---

## API Endpoints

**Swagger URL: http://localhost:8080/swagger-ui/index.html#**

### 1. **Create Personal, Address, and KYC Data**
- **Method**: `POST`
- **Endpoint**: `/api/customers/save`
- **Description**: This endpoint accepts a request containing personal, address, and KYC data, and stores it in the corresponding tables.
- **Request Body Example**:
    ```json
    {
        "firstName": "Rajesh",
        "lastName": "Kumar",
        "email": "rajesh.kumar@example.com",
        "phoneNumber": "9876501234",
        "street": "45 Gandhi Road",
        "city": "Chennai",
        "state": "Tamil Nadu",
        "zipCode": "600001",
        "documentType": "PAN",
        "documentNumber": "ABCDE1234F"
    }
    ```

### 2. **Update Personal, Address, and KYC Data**
- **Method**: `PUT`
- **Endpoint**: `/api/customers/update/{id}`
- **Description**: Updates the existing user data in the personal, address, and KYC tables based on the provided ID and data in the request body.

### 3. **Delete Personal, Address, and KYC Data**
- **Method**: `DELETE`
- **Endpoint**: `/api/customers/delete/{id}`
- **Description**: Deletes the details of a user from the personal, address, and KYC tables based on the provided ID.

---
## Response
The API returns a JSON response confirming the received data or indicating an error if validation fails.

### Success Response in JSON
```
{
  "status": "success",
  "message": "Customer Information updated successfully!"
}
```

### Error Response in JSON
```
Error: response status is 400

{
  "timestamp": "2025-02-08T12:47:45.172+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/api/customers/update/12"
}
```

---
## Technologies Used

- **Spring Boot**: For building the RESTful API.
- **JPA (Java Persistence API)**: For database interaction and performing CRUD operations using Spring Data JPA.
- **MySQL**: Relational database management systems for storing user data.
- **Maven**: For project management and dependency management.
- 	**Java**: Programming language used to build the application.
- 	**Spring Data JPA**: To simplify database operations and manage entities.


---

## Swagger UI Screenshots 

Here are screenshots of the Swagger UI for visual reference:

## 1. Update method

<img width="714" alt="updateOperation1" src="https://github.com/user-attachments/assets/984d6d54-7043-456a-b321-c7ec9982a935" />
<img width="713" alt="updateOperation2" src="https://github.com/user-attachments/assets/029e6609-ba8b-4e72-9a71-5cf44ccccf3e" />
<br>
<br>

## 2. Insert method

<img width="713" alt="SaveOperation1" src="https://github.com/user-attachments/assets/455edeaf-72b8-4971-9048-592d4f39477e" />
<img width="712" alt="SaveOperation2" src="https://github.com/user-attachments/assets/9e91900f-4217-461a-a3d1-de08865afa09" />
<br>
<br>

## 3. Delete method

<img width="445" alt="deleteOperation" src="https://github.com/user-attachments/assets/6c5c1790-a7e2-4f37-acc9-267dddd69cfd" />
<br>
<br>

---

## Special Thanks
- Thanks to the Spring Boot and JPA communities for their amazing frameworks and documentation.
- Inspired by various open-source projects.






