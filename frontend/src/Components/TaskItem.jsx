import React, { useState } from 'react';

const TaskItem = ({ task, onToggle, onDelete, onUpdate }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [editedTitle, setEditedTitle] = useState(task.title);
  const [editedDescription, setEditedDescription] = useState(task.description);
  const [editedDueDate, setEditedDueDate] = useState(task.dueDate);

  const handleUpdate = () => {
    onUpdate(task.id, { 
      ...task, 
      title: editedTitle, 
      description: editedDescription, 
      dueDate: editedDueDate 
    });
    setIsEditing(false);
  };

  return (
    <li className="list-group-item d-flex justify-content-between align-items-center">
      {isEditing ? (
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
        <>
          <div className="d-flex align-items-center">
            <input
              type="checkbox"
              className="form-check-input me-2"
              checked={task.status === 1}
              onChange={() => onToggle(task.id)}
            />
            <div>
              <h5 style={{ textDecoration: task.status === 1 ? 'line-through' : 'none' }}>
                {task.title}
              </h5>
              <p>{task.description}</p>
              <small>Due: {new Date(task.dueDate).toLocaleDateString()}</small>
            </div>
          </div>
          <div>
            <button className="btn btn-sm btn-outline-primary me-2" onClick={() => setIsEditing(true)}>
              Edit
            </button>
            <button className="btn btn-sm btn-outline-danger" onClick={() => onDelete(task.id)}>
              Delete
            </button>
          </div>
        </>
      )}
    </li>
  );
};

export default TaskItem;
