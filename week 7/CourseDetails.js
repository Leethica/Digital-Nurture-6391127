import React from 'react';
const courses = [
  { title: 'Angular', date: '4/5/2021' },
  { title: 'React', date: '6/3/2021' }
];

function CourseDetails() {
  return (
    <div className="card">
      <h2>Course Details</h2>
      {courses.map((course, index) => (
        <div key={index}>
          <p><strong>{course.title}</strong></p>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;
