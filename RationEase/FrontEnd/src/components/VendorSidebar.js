import React from "react";
import { NavLink } from "react-router-dom";
import "./VendorSidebar.css";

const VendorSidebar = () => {
  return (
    <div className="vendor-sidebar">
      <NavLink
        to="/vendor-profile"
        className="nav-link"
        activeClassName="active"
      >
        Profile
      </NavLink>
      <NavLink
        to="/vendor-slot-booked"
        className="nav-link"
        activeClassName="active"
      >
        Slot Booked
      </NavLink>
      <NavLink
        to="/vendor-stock-available"
        className="nav-link"
        activeClassName="active"
      >
        Stock Available
      </NavLink>
      <NavLink
        to="/vendor-testing"
        className="nav-link"
        activeClassName="active"
      >
        Testing
      </NavLink>
      <NavLink
        to="/vendor-logout"
        className="nav-link"
        activeClassName="active"
      >
        Logout
      </NavLink>
    </div>
  );
};

export default VendorSidebar;
