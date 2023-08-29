import React from "react";
import { Link } from "react-router-dom";
import "./Logout.css"; // Import your custom CSS file

const Logout = () => {
  return (
    <div className="logout-container">
      <h2>You have successfully logged out</h2>
      <Link to="/" className="back-home-link">
        Back to Home
      </Link>
    </div>
  );
};

export default Logout;
