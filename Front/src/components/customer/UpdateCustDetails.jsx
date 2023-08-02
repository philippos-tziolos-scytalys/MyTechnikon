import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Modal, Form, Button, Row } from 'react-bootstrap';

export default function UpdateCustDetails({ showModal, toggleModal, userId }) {
  let navigate = useNavigate();

  const { userID } = useParams();

  const [user, setUser] = useState({
    name: "",
    surname: "",
    username: "",
    email: "",
    address: "",
    phone: "",
    id: ""
  });

  const { name, surname, username, email, address, phone } = user;

  const onInputChange = (e) => {
    const { name, value } = e.target;
    setUser((prevState) => ({
      ...prevState,
      [name]: name === 'phone' ? value.replace(/\D/g, '') : value,
    }));
  };

  
  useEffect(() => {
    if (userId) {
      loadUser();
    }
  }, [userId]);

  const onClick = async (e) => {
    e.preventDefault();
    console.log("Submitting form...");
    try {
      await axios.put(`http://localhost:8080/users`, user);
      toggleModal();
      window.location.reload();
      console.log("User successfully updated!");
    } catch (error) {
      if (error.response.status === 500) {
        alert("Username, email, or tin number already exists");
      } else {
        alert("An error occurred. Please try again.");
      }
    }
  };

  const loadUser = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/users/${userId}`);
      setUser(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };
  return (
    <>
      <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Customer Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
      <Form className='modal-form'>

              <Row>
                  <Form.Group controlId="name">
                    <Form.Label>First name</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="Name: e.g. John"
                      value={name}
                      name="name"
                      onChange={(e) => onInputChange(e)}
                    />
                  </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="lastname">
                  <Form.Label>Last Name</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Last Name: e.g. Williams"
                    value={surname}
                    name="surname"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="username">
                  <Form.Label>Username</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Customer's username"
                    value={username}
                    name="username"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="email">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    placeholder="Email"
                    value={email}
                    name="email"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
                </Row>
                <Row>
                <Form.Group controlId="phone">
                  <Form.Label>Phone number</Form.Label>
                  <Form.Control
                    type={"number"}
                    placeholder="e.g. 0123456789"
                    value={phone}
                    name="phone"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="address">
                  <Form.Label>Address</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="e.g. Example street 123, Athens, Greece"
                    value={address}
                    name="address"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
        </Form>
    </Modal.Body>
    <Modal.Footer>
          <div className='button-container' type='submit'>
            <Button className='btn btn-primary' onClick={(e) => onClick(e)}>Update account</Button>
            <Button className='btn btn-secondary' onClick={toggleModal}>Cancel</Button>
          </div>
        </Modal.Footer>
  </Modal>
  </>
  );
}