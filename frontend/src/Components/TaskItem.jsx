import React, { useState } from 'react';

// TaskItem component: displays and manages an individual task item
const TaskItem = ({ task, onToggle, onDelete, onUpdate }) => {
  // State variables for managing editing mode and edited task details
  const [isEditing, setIsEditing] = useState(false);
  const [editedTitle, setEditedTitle] = useState(task.title);
  const [editedDescription, setEditedDescription] = useState(task.description);
  const [editedDueDate, setEditedDueDate] = useState(task.dueDate);

  // Function to handle task update
  const handleUpdate = () => {
    onUpdate(task.id, { 
      ...task, 
      title: editedTitle, 
      description: editedDescription, 
      dueDate: editedDueDate 
    });
    setIsEditing(false); // Exit editing mode
  };// End Method

  return (
    // List item representing a task
    <li className="list-group-item d-flex justify-content-between align-items-center">
      {isEditing ? (
        // Editing mode: show input fields for editing task details
        <div className="w-100">
          <input
            type="text"
            className="form-control mb-2"
            value={editedTitle}
            onChange={(e) => setEditedTitle(e.target.value)}
            autoFocus
          />
          <textarea
            className="form-control mb-2"
            value={editedDescription}
            onChange={(e) => setEditedDescription(e.target.value)}
          />
          <input
            type="date"
            className="form-control mb-2"
            value={editedDueDate}
            onChange={(e) => setEditedDueDate(e.target.value)}
          />
          <button className="btn btn-primary me-2" onClick={handleUpdate}>Save</button>
          <button className="btn btn-secondary" onClick={() => setIsEditing(false)}>Cancel</button>
        </div>
      ) : (
        // Display mode: show task details and action buttons
        <>
          <div className="d-flex align-items-center">
            {/* Checkbox to toggle task status */}
            <input
              type="checkbox"
              className="form-check-input me-2"
              checked={task.status === 1}
              onChange={() => onToggle(task.id)}
            />
            <div>
              {/* Task title with conditional line-through style */}
              <h5 style={{ textDecoration: task.status === 1 ? 'line-through' : 'none' }}>
                {task.title}
              </h5>
              <p>{task.description}</p>
              <small>Due: {new Date(task.dueDate).toLocaleDateString()}</small>
            </div>
          </div>
          <div>
            {/* Edit button to enter editing mode */}
            <button className="btn btn-sm btn-outline-primary me-2" onClick={() => setIsEditing(true)}>
              Edit
            </button>
            {/* Delete button to remove the task */}
            <button className="btn btn-sm btn-outline-danger" onClick={() => onDelete(task.id)}>
              Delete
            </button>
          </div>
        </>
      )}
    </li>
  );// End Return
};// End Component

export default TaskItem;
