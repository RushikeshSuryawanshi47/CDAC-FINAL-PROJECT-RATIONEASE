import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./HomePage.css";
import SideBar from "../components/Sidebar";
import VendorSidebar from "../components/VendorSidebar";

const HomePage = () => {
  return (
    // <div className="home-container">
    //   <div className="left-sidebar">
    //     <ul className="nav flex-column">
    //       <li className="nav-item">
    //         <Link to="/profile" className="nav-link">
    //           Profile
    //         </Link>
    //       </li>
    //       <li className="nav-item">
    //         <Link to="/slot-booking" className="nav-link">
    //           Slot Booking
    //         </Link>
    //       </li>
    //       <li className="nav-item">
    //         <Link to="/status" className="nav-link">
    //           Status
    //         </Link>
    //       </li>
    //       <li className="nav-item">
    //         <Link to="/logout" className="nav-link">
    //           Logout
    //         </Link>
    //       </li>
    //     </ul>
    //   </div>
    //   <div className="content">
    //     <Outlet />
    //   </div>
    // </div>

    <>
      {/* commenting for tesing homepage of vendor */}
      <SideBar />
      {/* <VendorSidebar /> */}
    </>
  );
};

export default HomePage;
