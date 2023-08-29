import React, { useState } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./SlotBooking.css";
import SideBar from "./Sidebar";

const BookingForm = () => {
  const [bookingId] = useState("12345"); // Replace with backend-generated value
  const [userId, setUserId] = useState("");
  const [selectedDate, setSelectedDate] = useState(null);
  const [selectedSlot, setSelectedSlot] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const availableSlots = [
    "10:00AM - 12:30PM",
    "2:00PM - 4:00PM",
    "4:00PM - 5:00PM",
  ];

  const handleUserIdChange = (event) => {
    setUserId(event.target.value);
  };

  const handleDateChange = (date) => {
    setSelectedDate(date);
  };

  const handleSlotChange = (event) => {
    setSelectedSlot(event.target.value);
  };

  const handleBookSlot = () => {
    // Perform backend logic to book the slot
    // Validate inputs before submitting
    if (!userId || !selectedDate || !selectedSlot) {
      setErrorMessage("Please fill in all fields.");
      return;
    }

    // Proceed with booking logic
    setErrorMessage("");
    // Example: send data to backend
    // const bookingData = { bookingId, userId, selectedDate, selectedSlot };
    // sendDataToBackend(bookingData);
  };

  // const handleGoBack = () => {
  //   // If using React Router, use history.goBack();
  //   // If not using React Router, you can use window.history.back();
  //   window.history.back();
  // };

  const handleGoBack = () => {
    // Redirect to the home page
    window.location.href = "/";
    // <HomePage />;
  };

  const isFormValid = userId && selectedDate && selectedSlot;

  return (
    <>
      <SideBar />
      <div className="booking-form-container">
        <div className="booking-form-card">
          <h2> Book Slot </h2>
          <div className="booking-form-fields">
            <div className="booking-form-field">
              <label>Booking ID:</label>
              <span>{bookingId}</span>
            </div>
            <div className="booking-form-field">
              <label>User ID:</label>
              <input
                type="text"
                value={userId}
                onChange={handleUserIdChange}
                placeholder="Enter your user ID"
              />
            </div>
            <div className="booking-form-field">
              <label>Select Date:</label>
              <Calendar
                onChange={handleDateChange}
                value={selectedDate}
                minDate={new Date()} // Disable past dates
                maxDate={
                  new Date(
                    new Date().getFullYear(),
                    new Date().getMonth() + 1,
                    0
                  )
                } // Disable future dates
                tileDisabled={({ date }) =>
                  date.getDay() === 0 || date.getDay() === 6
                } // Disable Sundays and Saturdays
              />
            </div>
            <div className="booking-form-field">
              <label>Select Slot:</label>
              <select value={selectedSlot} onChange={handleSlotChange}>
                <option value="">Select a slot</option>
                {availableSlots.map((slot, index) => (
                  <option key={index} value={slot}>
                    {slot}
                  </option>
                ))}
              </select>
            </div>
          </div>
          {errorMessage && <div className="error-message">{errorMessage}</div>}
          <div className="booking-form-buttons">
            <button
              className="book-button"
              onClick={handleBookSlot}
              disabled={!isFormValid}
            >
              Book Slot
            </button>
            <button className="back-button" onClick={handleGoBack}>
              Go Back
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default BookingForm;
