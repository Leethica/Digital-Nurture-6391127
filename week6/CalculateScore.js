import React from 'react';
import './CalculateScore.css'; // optional for styles

function CalculateScore(props) {
  // Destructure the props
  const { name, college, total, goal } = props;

  // Assuming average score = total / goal
  const average = total / goal;

  return (
    <div className="score-card">
      <h2>Student Score Calculator</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>College:</strong> {college}</p>
      <p><strong>Total Score:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
