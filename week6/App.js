import React from 'react';
import './App.css';
import CalculateScore from './components/CalculateScore';

function App() {
  return (
    <div className="App">
      <h1>Student Management Portal</h1>
      <CalculateScore 
        name="Leethica S"
        college="Sri Manakula Vinayagar Engineering College"
        total={450}
        goal={5}
      />
    </div>
  );
}

export default App;

