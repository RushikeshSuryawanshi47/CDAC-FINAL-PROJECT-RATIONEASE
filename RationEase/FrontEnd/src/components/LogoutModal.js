import React, { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import { Modal, Button } from "react-bootstrap";

const LogoutModal = () => {
  const [show, setShow] = useState(true);
  const history = useHistory();

  const handleClose = () => {
    setShow(false);
    history.push("/"); // Redirect to home on close without logout
  };

  const handleLogout = () => {
    // Perform logout action here
    setShow(false);
    // You can add your logout logic here
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Logout Confirmation</Modal.Title>
      </Modal.Header>
      <Modal.Body>Are you sure you want to log out?</Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleClose}>
          Cancel
        </Button>
        <Button variant="primary" onClick={handleLogout}>
          Logout
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default LogoutModal;
