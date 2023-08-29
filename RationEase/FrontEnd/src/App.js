import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
import LoginPage from "./pages/LoginPage";
import RegistrationPage from "./pages/RegistrationPage";
import HomePage from "./pages/HomePage";
import Profile from "./components/Profile";
import SlotBooking from "./components/SlotBooking";
import Status from "./components/Status";
import Logout from "./components/Logout";
import UpdateFamilyMember from "./pages/UpdateFamilyMember";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" exact element={<HomePage />} />
          <Route path="/login" exact element={<LoginPage />} />
          <Route path="/register" element={<RegistrationPage />} />

          <Route path="/profile" element={<Profile />} />
          <Route path="/slot-booking" element={<SlotBooking />} />
          <Route path="/status" element={<Status />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="/updatemember" element={<UpdateFamilyMember />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
