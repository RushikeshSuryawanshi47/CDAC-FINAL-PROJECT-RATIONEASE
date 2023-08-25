import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./HomePage.css";
import VendorSidebar from "../components/VendorSidebar";
import "./VendorHomePage.css";

const HomePage = () => {
  return (
    <div className="home-container">
      <div className="left-sidebar">
        <VendorSidebar />
      </div>
    </div>
  );
};

export default HomePage;
