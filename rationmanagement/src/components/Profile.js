import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./Profile.css"; // Import your custom CSS file
import { Link } from "react-router-dom";
import SideBar from "./Sidebar";

const Profile = () => {
  // Sample hardcoded data for family member list
  const familyMembers = [
    { id: 1, name: "John Doe", age: 30, relation: "Husband" },
    { id: 2, name: "Jane Doe", age: 28, relation: "Spouse" },
    { id: 3, name: "Jane Doe", age: 20, relation: "Daughter" },
    { id: 4, name: "Jane Doe", age: 17, relation: "Son" },
    { id: 5, name: "Jane Doe", age: 14, relation: "Daughter" },
  ];

  // Sample hardcoded data for slot bookings
  const slotBookings = [
    {
      id: 1,
      date: "2023-08-15",
      time: "10:00 AM",
      status: "Confirmed",
      isCollected: true,
    },
    {
      id: 2,
      date: "2023-08-20",
      time: "3:00 PM",
      status: "Pending",
      isCollected: false,
    },
  ];

  return (
    <>
      <div className="profile-container">
        <SideBar />
        <section className="section">
          <h2>Personal Information</h2>
          <div className="row">
            <div className="col-md-4">
              <div className="info-card">
                <h4>Card No:</h4>
                <p>123456789</p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="info-card">
                <h4>First Name:</h4>
                <p>John</p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="info-card">
                <h4>Middle Name:</h4>
                <p>Robert</p>
              </div>
            </div>
          </div>
        </section>

        <section className="section">
          <h2>Family Members</h2>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Relation</th>
              </tr>
            </thead>
            <tbody>
              {familyMembers.map((member) => (
                <tr key={member.id}>
                  <td>{member.id}</td>
                  <td>{member.name}</td>
                  <td>{member.age}</td>
                  <td>{member.relation}</td>
                </tr>
              ))}
            </tbody>
          </table>

          <div className="mt-4">
            <Link to="/updatemember" className="btn btn-secondary">
              Update Family Member
            </Link>
          </div>
        </section>

        <section className="section">
          <h2>Slot Bookings</h2>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Collected</th>
              </tr>
            </thead>
            <tbody>
              {slotBookings.map((booking) => (
                <tr key={booking.id}>
                  <td>{booking.id}</td>
                  <td>{booking.date}</td>
                  <td>{booking.time}</td>
                  <td>{booking.status}</td>
                  <td>{booking.isCollected ? "Yes" : "No"}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </section>

        <div className="mt-4">
          <Link to="/" className="btn btn-secondary">
            Back
          </Link>
        </div>
      </div>
    </>
  );
};

export default Profile;
