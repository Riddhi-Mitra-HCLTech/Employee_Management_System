import { useState, useEffect } from "react";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import { useNavigate } from "react-router-dom"; 

const Dashboard = () => {

    const [employee, setEmployee] = useState([]);

    const navigate = useNavigate(); 

    const fetchEmployees = async () => {
            try {
                const response = await fetch("http://localhost:8091/employee/getAll");
                const data = await response.json();
                setEmployee(data);
            } catch(error) {
                console.log("Error fetching employees");
            }
        }

    useEffect(() => {
        fetchEmployees();
    }, []);

    const handleDelete = async (employeeId) => {
        try {
           const response = await fetch(`http://localhost:8091/employee/delete/${employeeId}`,{
            method: "DELETE",
        }); 

        if(response.ok) {
            setEmployee((prevEmployee) => 
                prevEmployee.filter((employee) => employee.employeeId !== employeeId)
            )
        }
        console.log(`Employee with ID: ${employeeId} has been deleted successfully`);
        } catch(error) {
            console.error("Error deleting employee:",error.message);
        }
    }

    const hanldeUpdate = (employeeId) => {
        navigate(`/update/employee/${employeeId}`)
    }

    return (
        <>
        <Container className="mt-5">
            <Row>
                <Col>
                    <h1 className="text-center">Employees</h1>
                    <br/><br/>
                    <Table className="table table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Department</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {employee.map((employee) => (
                                <tr key={employee.employeeId}>
                                <td>{employee.name}</td>
                                <td>{employee.email}</td>
                                <td>{employee.phone}</td>
                                <td>{employee.department}</td>
                                <td>
                                    <Button variant="outline-secondary" onClick={() => hanldeUpdate(employee.employeeId)}>Update</Button>{" "}
                                    <Button variant="outline-danger" onClick={() => handleDelete(employee.employeeId)}>Delete</Button>
                                </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
        </>
    )
}

export default Dashboard;