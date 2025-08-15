# Employee Management System

A full-stack web application to manage employee records.
- Frontend: ReactJS
- Backend: Spring Boot
- Database: PostgreSQL

### Features
- Employee CRUD operations (Create, Read, Update, Delete)
- Responsive UI with Bootstrap
- RESTful API integration

### Setup
- git clone https://github.com/Riddhi-Mitra-HCLTech/Employee_Management_System.git
- cd Employee_Management_System

### Backend-Setup (runs on http://localhost:8091)
- cd Backend
- mvn spring-boot:run

### Frontend-Setup (runs on http://localhost:3000)
- cd Frontend
- npm install react-bootstrap bootstrap
- npm install react-router-dom
- npm install
- npm start

### API Endpoints (Provided in Swagger Docs)
- GET: /employee/getAll (get all employees)
- POST: /employee/register (regsiter new employee)
- PUT: /employee/get/{employeeId} (update employee details)
- DELETE: /employee/delete/{employeeId} (delete an employee)

### Author - Riddhi Mitra
