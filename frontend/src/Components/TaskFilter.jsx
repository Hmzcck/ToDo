import React from 'react';

// TaskFilter component: provides buttons to filter tasks by status
const TaskFilter = ({ filter, setFilter }) => {
  return (
    // Button group for filtering tasks
    <div className="btn-group mb-3" role="group">
      {/* Button to show all tasks */}
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'all' ? 'active' : ''}`}
        onClick={() => setFilter('all')}
      >
        All
      </button>
      {/* Button to show only tasks that are to-do */}
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'todo' ? 'active' : ''}`}
        onClick={() => setFilter('todo')}
      >
        Todo
      </button>
      {/* Button to show only tasks that are done */}
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'done' ? 'active' : ''}`}
        onClick={() => setFilter('done')}
      >
        Done
      </button>
    </div>
  );// End Return
};// End Component

export default TaskFilter;
