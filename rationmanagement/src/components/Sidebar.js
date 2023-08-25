import React from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
import "./Sidebar.css"; // Import your custom CSS file for the sidebar

const Sidebar = () => {
  return (
    <div className="sidebar bg-dark">
      <ul className="nav flex-column">
        <li className="nav-item">
          <Link to="/profile" className="nav-link text-light">
            <i className="bi bi-person"></i> Profile
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/slot-booking" className="nav-link text-light">
            <i className="bi bi-calendar-event"></i> Slot Booking
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/status" className="nav-link text-light">
            <i className="bi bi-info-circle"></i> Status
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/logout" className="nav-link text-light">
            <i className="bi bi-box-arrow-right"></i> Logout
          </Link>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
