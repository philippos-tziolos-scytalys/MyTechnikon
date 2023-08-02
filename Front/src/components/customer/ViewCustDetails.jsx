import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Button } from 'react-bootstrap';

export default function ViewCustDetails({ showModal, toggleModal, userId }) {

  const [user, setUser] = useState({
    tin: "",
    name: "",
    surname: "",
    username: "",
    email: "",
    address: "",
    phone: ""
  });

  useEffect(() => {
    if (userId) {
      loadUser();
    }
  }, [userId]);

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
        <div className="container">
          <div className="row">
              <h2 className="text-center m-4">User Details</h2>

              <div className="card">
                <div className="card-header">
                  Details of user id : {user.id}
                  <ul className="list-group list-group-flush">
                  <li className="list-group-item">
                      <b>Tin Number: </b>
                      {user.tin}
                    </li>
                    <li className="list-group-item">
                      <b>Name: </b>
                      {user.name}
                    </li>
                    <li className="list-group-item">
                      <b>Surame: </b>
                      {user.surname}
                    </li>
                    <li className="list-group-item">
                      <b>UserName: </b>
                      {user.username}
                    </li>
                    <li className="list-group-item">
                      <b>Email: </b>
                      {user.email}
                    </li>
                    <li className="list-group-item">
                      <b>Phone number: </b>
                      {user.phone}
                    </li>
                    <li className="list-group-item">
                      <b>Address: </b>
                      {user.address}
                    </li>
                  </ul>
                </div>
              </div>
          </div>
        </div>
    </Modal.Body>
    <Modal.Footer>
    <Button className='btn btn-primary mt-3' onClick={toggleModal}>Back home</Button>
    </Modal.Footer>
    </Modal>
    </>
  );
}