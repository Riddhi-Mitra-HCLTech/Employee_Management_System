## Employee Management System

A full-stack web application to manage employee records.
- Frontend: ReactJS
- Backend: Spring Boot
- Database: PostgreSQL

### Prerequisites
- npm(node package manager)
- Maven
- PostgreSQL

### Features
- Employee CRUD operations (Create, Read, Update, Delete)
- Responsive UI with Bootstrap
- RESTful API integration

### Setup
1. Clone the repository
    ```bash
    git clone https://github.com/Riddhi-Mitra-HCLTech/Employee_Management_System.git
    ```
2. Change directory
    ```bash
    Employee_Management_System
    ```

### Database Setup (Locally) - runs on PORT 5432

1. Open PostgreSQL shell:

   ```bash
   psql -U postgres -h localhost -p 5432
   ```

2. Inside the PostgreSQL shell, create the database:

   ```sql
   CREATE DATABASE "EmployeeManagementWebsiteDB";
   ```

### Backend-Setup (runs on http://localhost:8091)
1. Change directory
    ```bash
    cd Backend
    ```
2. Run backend server
    ```bash
    mvn spring-boot:run
    ```

### Frontend-Setup (runs on http://localhost:3000)
1. Change directory
    ```bash
    cd Frontend
    ```
2. Install Dependencies
    ```bash
    npm install react-bootstrap bootstrap react-router-dom
    ```
3. Run frontend server
    ```bash
    npm start
    ```

### API Endpoints (Provided in Swagger Docs)
- GET: /employee/getAll (get all employees)
- POST: /employee/register (regsiter new employee)
- PUT: /employee/get/{employeeId} (update employee details)
- DELETE: /employee/delete/{employeeId} (delete an employee)

### Author - Riddhi Mitra
