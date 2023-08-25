// const Status = ({ bookingData }) => {
// Replace this with your actual data fetching logic from the backend
// const [bookingData, setBookingData] = useState(null);
// useEffect(() => {
//   fetchDataFromBackend().then((data) => {
//     setBookingData(data);
//   });
// }, []);

import React from "react";
import "./Status.css"; // Import your custom CSS file
import SideBar from "./Sidebar";

const Status = ({ bookingData }) => {
  if (!bookingData) {
    // Replace this with hardcoded values
    const hardcodedBookingData = {
      bookingId: 12345,
      dateOfRegistration: "2023-08-23",
      timeOfCollection: "2:30 PM",
      status: "Collected",
      isCollected: true,
    };

    return (
      <>
        <SideBar />
        <div className="status-container">
          <div className="status-card ">
            <h2>Slot Booking Status</h2>
            <div className="booking-details">
              <div className="booking-field">
                <span className="field-label">Booking ID:</span>
                <span className="field-value">
                  {hardcodedBookingData.bookingId}
                </span>
              </div>
              <div className="booking-field">
                <span className="field-label">Date of Registration:</span>
                <span className="field-value">
                  {hardcodedBookingData.dateOfRegistration}
                </span>
              </div>
              <div className="booking-field">
                <span className="field-label">Time of Collection:</span>
                <span className="field-value">
                  {hardcodedBookingData.timeOfCollection}
                </span>
              </div>
              <div className="booking-field">
                <span className="field-label">Status:</span>
                <span className="field-value">
                  {hardcodedBookingData.status}
                </span>
              </div>
              <div className="booking-field">
                <span className="field-label">Collected:</span>
                <span className="field-value">
                  {hardcodedBookingData.isCollected ? "Yes" : "No"}
                </span>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }

  return (
    <>
      <div className="status-card">
        <h2>Slot Booking Status</h2>
        <div className="booking-details">
          <div className="booking-field">
            <span className="field-label">Booking ID:</span>
            <span className="field-value">{bookingData.bookingId}</span>
          </div>
          <div className="booking-field">
            <span className="field-label">Date of Registration:</span>
            <span className="field-value">
              {bookingData.dateOfRegistration}
            </span>
          </div>
          <div className="booking-field">
            <span className="field-label">Time of Collection:</span>
            <span className="field-value">{bookingData.timeOfCollection}</span>
          </div>
          <div className="booking-field">
            <span className="field-label">Status:</span>
            <span className="field-value">{bookingData.status}</span>
          </div>
          <div className="booking-field">
            <span className="field-label">Collected:</span>
            <span className="field-value">
              {bookingData.isCollected ? "Yes" : "No"}
            </span>
          </div>
        </div>
      </div>
    </>
  );
};

export default Status;
