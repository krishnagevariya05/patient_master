import axios from "axios";
import React, { useEffect, useState } from "react";
import { Container, Form, Card, Button } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";

export default function Patient(props) {
  const [id, setId] = useState(null);
  const [age, setAge] = useState(null);
  const [name, setName] = useState(null);
  const [address, setAddress] = useState(null);

  const { patientId } = useParams(); // Get the Path Parameter from the URL
  const navigate = useNavigate();

  useEffect(() => {
    if (patientId) {
      axios
        .get("http://localhost:8080/patient/" + patientId)
        .then((response) => {
          if (response.data != null) {
            setId(response.data.id);
            setAge(response.data.age);
            setName(response.data.name);
            setAddress(response.data.address);
          }
        })
        .catch((error) => props.showAlert("danger", "Error"));
    }
  }, []);

  let patient = {
    id: id,
    age: age,
    name: name,
    address: address,
  };

  let textChanged = (event) => {
    if (event.target.name === "id") {
      setId(event.target.value);
    }else if(event.target.name === "age"){
      setAge(event.target.value); 
    }
    else if (event.target.name === "name") {
      setName(event.target.value);
    } else if (event.target.name === "address") {
      setAddress(event.target.value);
    }
  };

  let savePatient = (event) => {
    event.preventDefault();
    
      axios
        .post("http://localhost:8080/patient", patient)
        .then((response) => {
          if (response.data != null) {
            props.showAlert("success", "Record added successfully");
          }
        })
        .catch((error) => props.showAlert("danger", "Error"));
  };

  let updatePatient = (event) => {
    event.preventDefault();
    axios.put("http://localhost:8080/patients/" + patientId, patient).then((response) => {
      if (response.data != null) {
        props.showAlert("success", "Record updated successfully");
        navigate("/listPatients"); 
      }
    });
  };

  return (
    <div className="my-3">
      <Container>
        <Card>
          <Form onSubmit={patientId != null ? updatePatient : savePatient}>
            <Card.Header>
              <strong>{patientId!=null? "Update Patient Information":"Add Patient Information"}</strong>
            </Card.Header>
            <Card.Body>
              <Form.Group className="mb-3">
                <Form.Label>Id</Form.Label>
                <Form.Control
                  name="id"
                  value={id}
                  type="text"
                  placeholder="Enter id"
                  onChange={textChanged}
                />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label>age</Form.Label>
                <Form.Control
                  name="age"
                  value={age}
                  type="text"
                  placeholder="Enter age"
                  onChange={textChanged}
                />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label>Name</Form.Label>
                <Form.Control
                  name="name"
                  value={name}
                  type="text"
                  placeholder="Enter name"
                  onChange={textChanged}
                />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label>Address</Form.Label>
                <Form.Control
                  name="address"
                  value={address}
                  type="text"
                  placeholder="Enter address"
                  onChange={textChanged}
                />
              </Form.Group>
            </Card.Body>
            <Card.Footer>
              <Button variant="primary" type="submit">
                {patientId != null ? "Update" : "Submit"}
              </Button>
            </Card.Footer>
          </Form>
        </Card>
      </Container>
    </div>
  );
}
