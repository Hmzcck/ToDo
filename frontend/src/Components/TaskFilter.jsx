import React from 'react';

const TaskFilter = ({ filter, setFilter }) => {
  return (
    <div className="btn-group mb-3" role="group">
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'all' ? 'active' : ''}`}
        onClick={() => setFilter('all')}
      >
        All
      </button>
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'todo' ? 'active' : ''}`}
        onClick={() => setFilter('todo')}
      >
        Todo
      </button>
      <button
        type="button"
        className={`btn btn-outline-primary ${filter === 'done' ? 'active' : ''}`}
        onClick={() => setFilter('done')}
      >
        Done
      </button>
    </div>
  );
};

export default TaskFilter;