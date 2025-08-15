import { useEffect, useState } from 'react';
import './UpdateEmployee.css';
import { Button, Form } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateEmployee = () => {
  const { employeeId } = useParams();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    department: ""
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const fetchEmployee = async () => {
    try {
      const response = await fetch(`http://localhost:8091/employee/get/${employeeId}`);
      const data = await response.json();
      setFormData(data);
    } catch (error) {
      console.log("Error fetching employee: ", error.message);
    }
  };

  useEffect(() => {
    fetchEmployee();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
        const response = await fetch(`http://localhost:8091/employee/update/${employeeId}`,{
            method: "PUT",
            headers: {"Content-Type":"application/json",},
            body: JSON.stringify(formData)
        });

        const data = await response.json();
        console.log("Updated employee: ",data);
        navigate("/");
    } catch(error) {
        console.log("Error updating employee: ",error.message);
    }
  }

  return (
    <>
      <div className="center-form">
        <h2>Edit Employee</h2>
        <br />
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formName">
            <Form.Control
              type="text"
              name="name"
              placeholder="Enter Name"
              value={formData.name}
              onChange={handleInputChange}
            />
          </Form.Group>

          <Form.Group controlId="formEmail">
            <Form.Control
              type="email"
              name="email"
              placeholder="Enter Email"
              value={formData.email}
              onChange={handleInputChange}
            />
          </Form.Group>

          <Form.Group controlId="formPhone">
            <Form.Control
              type="text"
              name="phone"
              placeholder="Enter Phone Number"
              value={formData.phone}
              onChange={handleInputChange}
            />
          </Form.Group>

          <Form.Group controlId="formDepartment">
            <Form.Control
              type="text"
              name="department"
              placeholder="Enter Department"
              value={formData.department}
              onChange={handleInputChange}
            />
          </Form.Group>

          <Button variant="primary" type="submit" className="w-100">
            Edit
          </Button>
        </Form>
      </div>
    </>
  );
};

export default UpdateEmployee;
