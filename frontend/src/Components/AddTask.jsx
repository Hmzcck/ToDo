import React, { useState } from 'react';

// AddTask component: a form for adding a new task
const AddTask = ({ onAdd }) => {
  // State variables for the task's title, description, and due date
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [dueDate, setDueDate] = useState('');

  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent the default form submission behavior
    if (!title.trim() || !dueDate) return; // Do nothing if title or due date is empty
    // Call the onAdd function passed as a prop with the new task data
    onAdd({
      title,
      description,
      status: 0,
      dueDate
    });
    // Clear the form fields after submission
    setTitle('');
    setDescription('');
    setDueDate('');
  };// End Method

  return (
    // Form element with an onSubmit handler
    <form onSubmit={handleSubmit} className="mb-3">
      <div className="mb-3">
        {/* Input field for the task title */}
        <input
          type="text"
          className="form-control"
          placeholder="Task title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
      </div>
      <div className="mb-3">
        {/* Textarea for the task description (optional) */}
        <textarea
          className="form-control"
          placeholder="Task description (optional)"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </div>
      <div className="mb-3">
        {/* Input field for the task due date */}
        <input
          type="date"
          className="form-control"
          value={dueDate}
          onChange={(e) => setDueDate(e.target.value)}
          required
        />
      </div>
      {/* Submit button */}
      <button className="btn btn-primary" type="submit">Add Task</button>
    </form>
  );// End Return
};// End Component

export default AddTask;
