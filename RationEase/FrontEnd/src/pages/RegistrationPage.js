import React, { useState } from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";

const LoginPage = () => {
  const [showRegistration, setShowRegistration] = useState(false);
  const [cardNo, setCardNo] = useState("123456"); // Replace with generated value
  const [firstName, setFirstName] = useState("");
  const [middleName, setMiddleName] = useState("");
  const [lastName, setLastName] = useState("");
  const [dob, setDob] = useState("");
  const [familyMembers, setFamilyMembers] = useState([]);
  const [newFamilyMember, setNewFamilyMember] = useState({
    firstName: "",
    lastName: "",
    dob: "",
    relationship: "",
  });

  const handleAddFamilyMember = () => {
    setFamilyMembers([...familyMembers, newFamilyMember]);
    setNewFamilyMember({
      firstName: "",
      lastName: "",
      dob: "",
      relationship: "",
    });
  };

  const handleRemoveFamilyMember = (index) => {
    const updatedFamilyMembers = familyMembers.filter((_, i) => i !== index);
    setFamilyMembers(updatedFamilyMembers);
  };

  const calculateAge = (birthDate) => {
    const currentDate = new Date();
    const dob = new Date(birthDate);
    const age = currentDate.getFullYear() - dob.getFullYear();
    const monthDiff = currentDate.getMonth() - dob.getMonth();

    if (
      monthDiff < 0 ||
      (monthDiff === 0 && currentDate.getDate() < dob.getDate())
    ) {
      return age - 1;
    }

    return age;
  };

  const handleFamilyMemberChange = (event, index, field) => {
    const updatedMembers = [...familyMembers];
    const memberToUpdate = { ...updatedMembers[index] };
    memberToUpdate[field] = event.target.value;
    updatedMembers[index] = memberToUpdate;
    setFamilyMembers(updatedMembers);
  };

  const handleRegister = () => {
    // Perform registration logic here
  };

  return (
    // <div className="container mt-5">
    //   <div className="row justify-content-center">
    //     <div className="col-md-6">
    //       <div className="card rounded">
    //         <div className="card-header">Login Page</div>
    //         <div className="card-body">

    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-8">
          <div className="card rounded custom-card">
            <div className="card-header">Login Page</div>
            <div className="card-body">
              {showRegistration ? (
                <div>
                  <h5>Registration Form</h5>
                  <form>
                    <div className="mb-3">
                      <label htmlFor="cardNo" className="form-label">
                        Card Number
                      </label>
                      <input
                        type="text"
                        className="form-control"
                        id="cardNo"
                        value={cardNo}
                        readOnly
                      />
                    </div>
                    <div className="row mb-3">
                      <div className="col">
                        <label htmlFor="firstName" className="form-label">
                          First Name
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="firstName"
                          value={firstName}
                          onChange={(e) => setFirstName(e.target.value)}
                        />
                      </div>
                      <div className="col">
                        <label htmlFor="middleName" className="form-label">
                          Middle Name
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="middleName"
                          value={middleName}
                          onChange={(e) => setMiddleName(e.target.value)}
                        />
                      </div>
                      <div className="col">
                        <label htmlFor="lastName" className="form-label">
                          Last Name
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="lastName"
                          value={lastName}
                          onChange={(e) => setLastName(e.target.value)}
                        />
                      </div>
                    </div>
                    {/* Date of Birth */}
                    <div className="mb-3">
                      <label htmlFor="dob" className="form-label">
                        Date of Birth
                      </label>
                      <input
                        type="date"
                        className="form-control"
                        id="dob"
                        value={dob}
                        onChange={(e) => setDob(e.target.value)}
                      />
                    </div>
                    {/* Age */}
                    <div className="mb-3">
                      <label htmlFor="age" className="form-label">
                        Age
                      </label>
                      <input
                        type="text"
                        className="form-control"
                        id="age"
                        value={calculateAge(dob)}
                        readOnly
                      />
                    </div>
                    {/* Family Members */}
                    <h5>Family Members</h5>
                    <div className="mb-3">
                      <label htmlFor="numFamilyMembers" className="form-label">
                        Number of Family Members
                      </label>
                      <input
                        type="number"
                        className="form-control"
                        id="numFamilyMembers"
                        value={familyMembers.length}
                        readOnly
                      />
                    </div>
                    {familyMembers.map((member, index) => (
                      <div key={index} className="mb-3 border p-3">
                        <p>Family Member {index + 1}</p>
                        <div className="row">
                          <div className="col">
                            <label
                              htmlFor={`fmFirstName_${index}`}
                              className="form-label"
                            >
                              First Name
                            </label>
                            <input
                              type="text"
                              className="form-control"
                              id={`fmFirstName_${index}`}
                              value={member.firstName}
                              onChange={(e) =>
                                handleFamilyMemberChange(e, index, "firstName")
                              }
                            />
                          </div>
                          <div className="col">
                            <label
                              htmlFor={`fmLastName_${index}`}
                              className="form-label"
                            >
                              Last Name
                            </label>
                            <input
                              type="text"
                              className="form-control"
                              id={`fmLastName_${index}`}
                              value={member.lastName}
                              onChange={(e) =>
                                handleFamilyMemberChange(e, index, "lastName")
                              }
                            />
                          </div>
                        </div>
                        <div className="row mt-2">
                          <div className="col">
                            <label
                              htmlFor={`fmDOB_${index}`}
                              className="form-label"
                            >
                              Date of Birth
                            </label>
                            <input
                              type="date"
                              className="form-control"
                              id={`fmDOB_${index}`}
                              value={member.dob}
                              onChange={(e) =>
                                handleFamilyMemberChange(e, index, "dob")
                              }
                            />
                          </div>
                          <div className="col">
                            <label
                              htmlFor={`fmRelationship_${index}`}
                              className="form-label"
                            >
                              Relationship
                            </label>
                            <input
                              type="text"
                              className="form-control"
                              id={`fmRelationship_${index}`}
                              value={member.relationship}
                              onChange={(e) =>
                                handleFamilyMemberChange(
                                  e,
                                  index,
                                  "relationship"
                                )
                              }
                            />
                          </div>
                        </div>
                        <button
                          type="button"
                          className="btn btn-danger btn-sm mt-2"
                          onClick={() => handleRemoveFamilyMember(index)}
                        >
                          Remove
                        </button>
                      </div>
                    ))}
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={handleAddFamilyMember}
                    >
                      Add Family Member
                    </button>

                    <table className="table mt-3">
                      <thead>
                        <tr>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Date of Birth</th>
                          <th>Relationship</th>
                          <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                        {familyMembers.map((member, index) => (
                          <tr key={index}>
                            <td>{member.firstName}</td>
                            <td>{member.lastName}</td>
                            <td>{member.dob}</td>
                            <td>{member.relationship}</td>
                            <td>
                              <button
                                type="button"
                                className="btn btn-danger btn-sm"
                                onClick={() => handleRemoveFamilyMember(index)}
                              >
                                Remove
                              </button>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>

                    <div className="d-grid gap-2 mt-3">
                      <button
                        type="button"
                        className="btn btn-success"
                        onClick={handleRegister}
                      >
                        Register
                      </button>

                      {/* <button
                    type="button"
                    className="btn btn-success"
                    onClick={() => setShowRegistration(true)}
                  > */}

                      <button
                        type="button"
                        className="btn btn-secondary"
                        onClick={() => setShowRegistration(false)}
                      >
                        Go back
                      </button>
                    </div>
                  </form>
                </div>
              ) : (
                <form>
                  {/* Existing login form */}
                  {/* ... */}
                  <button
                    type="button"
                    className="btn btn-success"
                    onClick={() => setShowRegistration(true)}
                  >
                    Register
                  </button>
                </form>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
