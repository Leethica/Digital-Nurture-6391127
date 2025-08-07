// src/App.js
import React from 'react';
import './App.css';

function App() {
  // Object for a single office
  const singleOffice = {
    name: 'WorkHub Space',
    rent: 55000,
    address: '123, Tech Park, Chennai'
  };

  // List of multiple offices
  const officeList = [
    { name: 'TechSpace One', rent: 45000, address: 'Anna Nagar, Chennai' },
    { name: 'InnovateHub', rent: 65000, address: 'Tidel Park, Chennai' },
    { name: 'Startup Arena', rent: 58000, address: 'Guindy, Chennai' },
    { name: 'Corporate Corner', rent: 70000, address: 'OMR, Chennai' }
  ];

  // Inline style logic for rent color
  const getRentStyle = (rent) => {
    return {
      color: rent < 60000 ? 'red' : 'green',
      fontWeight: 'bold'
    };
  };

  return (
    <div className="App" style={{ fontFamily: 'Arial', padding: '20px' }}>
      {/* Heading using JSX */}
      <h1>🏢 Office Space Rental App</h1>

      {/* Image with JSX attributes */}
      <img
        src="https://images.unsplash.com/photo-1570129477492-45c003edd2be"
        alt="Office Space"
        style={{ width: '400px', height: '250px', borderRadius: '10px', marginBottom: '20px' }}
      />

      {/* Display a single object */}
      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {singleOffice.name}</p>
      <p><strong>Address:</strong> {singleOffice.address}</p>
      <p>
        <strong>Rent:</strong>{' '}
        <span style={getRentStyle(singleOffice.rent)}>{singleOffice.rent}</span>
      </p>

      <hr />

      {/* Looping through a list of office objects */}
      <h2>All Office Spaces</h2>
      <ul>
        {officeList.map((office, index) => (
          <li key={index} style={{ marginBottom: '15px' }}>
            <p><strong>Name:</strong> {office.name}</p>
            <p><strong>Address:</strong> {office.address}</p>
            <p>
              <strong>Rent:</strong>{' '}
              <span style={getRentStyle(office.rent)}>{office.rent}</span>
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
