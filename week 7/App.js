import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  // Element variables
  let message;
  let button;
  let pageContent;

  if (isLoggedIn) {
    message = <h2>Welcome back</h2>;
    button = <button onClick={handleLogout}>Logout</button>;
    pageContent = <UserPage />;
  } else {
    message = <h2>Please sign up.</h2>;
    button = <button onClick={handleLogin}>Login</button>;
    pageContent = <GuestPage />;
  }

  return (
    <div className="App" style={{ padding: '30px', fontFamily: 'Arial', textAlign: 'center' }}>
      <h1>Ticket Booking App</h1>
      {message}
      <br /><br />
      {button}
      <hr style={{ margin: '20px 0' }} />
      {pageContent}
    </div>
  );
}
export default App;


