import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.css";
import { Link } from "react-router-dom";
import "./UpdateFamilyMember.css";
import SideBar from "../components/Sidebar";

const UpdateFamilyMember = () => {
  const [familyMembers, setFamilyMembers] = useState([
    { id: 1, name: "John Doe", age: 30, relation: "Husband" },
    { id: 2, name: "Jane Doe", age: 28, relation: "Spouse" },
    { id: 3, name: "Jane Doe", age: 20, relation: "Daughter" },
    { id: 4, name: "Jane Doe", age: 17, relation: "Son" },
    { id: 5, name: "Jane Doe", age: 14, relation: "Daughter" },
  ]);

  const handleAddMember = () => {
    // Implement logic to add a new family member
    const newMember = {
      id: familyMembers.length + 1,
      name: "New Member",
      age: 0,
      relation: "Unknown",
    };
    setFamilyMembers([...familyMembers, newMember]);
  };

  const handleUpdateMember = (id, newData) => {
    // Implement logic to update a family member
    const updatedMembers = familyMembers.map((member) =>
      member.id === id ? { ...member, ...newData } : member
    );
    setFamilyMembers(updatedMembers);
  };

  const handleDeleteMember = (id) => {
    // Implement logic to delete a family member
    const updatedMembers = familyMembers.filter((member) => member.id !== id);
    setFamilyMembers(updatedMembers);
  };

  return (
    <>
      <div>
        <SideBar />
      </div>
      <div className="update-family-member-container">
        <h2>Update Family Members</h2>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Age</th>
              <th>Relation</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {familyMembers.map((member) => (
              <tr key={member.id}>
                <td>{member.id}</td>
                <td>
                  <input
                    type="text"
                    value={member.name}
                    onChange={(e) =>
                      handleUpdateMember(member.id, { name: e.target.value })
                    }
                  />
                </td>
                <td>
                  <input
                    type="number"
                    value={member.age}
                    onChange={(e) =>
                      handleUpdateMember(member.id, {
                        age: parseInt(e.target.value),
                      })
                    }
                  />
                </td>
                <td>
                  <input
                    type="text"
                    value={member.relation}
                    onChange={(e) =>
                      handleUpdateMember(member.id, {
                        relation: e.target.value,
                      })
                    }
                  />
                </td>
                {/* <td>
                <button onClick={() => handleDeleteMember(member.id)}>
                  Delete
                </button>
              </td> */}

                <td>
                  <button
                    onClick={() => handleDeleteMember(member.id)}
                    className="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {/* <div className="mt-4">
        <button onClick={handleAddMember}>Add Member</button>
        <Link to="/profile" className="btn btn-secondary">
          Back
        </Link>
      </div> */}

        <div className="actions-container">
          <button className="btn btn-primary" onClick={handleAddMember}>
            Add Member
          </button>
          <Link to="/profile" className="btn btn-secondary back-button">
            Back
          </Link>
        </div>
      </div>
    </>
  );
};

export default UpdateFamilyMember;
