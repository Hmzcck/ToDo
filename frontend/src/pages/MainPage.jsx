import React, { useState, useEffect } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import taskService from "../services/TaskService";
import TaskItem from "../components/TaskItem";
import TaskFilter from "../components/TaskFilter";
import AddTask from "../components/AddTask";

const App = () => {
  const [tasks, setTasks] = useState([]);
  const [filter, setFilter] = useState("all");

  useEffect(() => {
    const fetchData = async () => {
      const data = await taskService.fetchTasks();
      if (data) setTasks(data);
    };
    fetchData();
  }, []);

  const addTask = async (newTask) => {
    const task = await taskService.addTask(newTask);
    if (task) {
      setTasks([...tasks, task]);
      toast.success("Task added successfully");
    }
  };

  const updateTask = async (id, updatedTask) => {
    const task = await taskService.updateTask(id, updatedTask);
    if (task) {
      setTasks(
        tasks.map((t) =>
          t.id === id ? { ...t, ...updatedTask } : t
        )
      );
      toast.success("Task updated successfully");
    }
  };

  const deleteTask = async (id) => {
    await taskService.deleteTask(id);
    setTasks(tasks.filter((task) => task.id !== id));
    toast.success("Task deleted successfully");
  };

  const toggleComplete = async (id) => {
    const task = tasks.find((t) => t.id === id);
    await updateTask(id, { ...task, status: task.status === 0 ? 1 : 0 });
  };

  const deleteAllTasks = async () => {
    await taskService.deleteAllTasks();
    setTasks([]);
    toast.success("All tasks deleted successfully");
  };

  const deleteCompletedTasks = async () => {
    const completedTaskIds = tasks
      .filter((task) => task.status === 1)
      .map((task) => task.id);
    await taskService.deleteCompletedTasks(completedTaskIds);
    setTasks(tasks.filter((task) => task.status === 0));
    toast.success("Completed tasks deleted successfully");
  };

  const sortedTasks = tasks.sort(
    (a, b) => new Date(a.dueDate) - new Date(b.dueDate)
  );

  const filteredTasks = sortedTasks.filter((task) => {
    if (filter === "todo") return task.status === 0;
    if (filter === "done") return task.status === 1;
    return true;
  });

  return (
    <div className="container mt-5">
      <ToastContainer />
      <h1 className="text-center mb-4">Todo App</h1>
      <AddTask onAdd={addTask} />
      <TaskFilter filter={filter} setFilter={setFilter} />
      <div className="mb-3">
        <button className="btn btn-danger me-2" onClick={deleteAllTasks}>Delete All Tasks</button>
        <button className="btn btn-warning" onClick={deleteCompletedTasks}>Delete Completed Tasks</button>
      </div>
      <div>
        {filteredTasks.length > 0 ? (
          filteredTasks.map((task) => (
            <TaskItem
              key={task.id}
              task={task}
              onToggle={toggleComplete}
              onDelete={deleteTask}
              onUpdate={updateTask}
            />
          ))
        ) : (
          <p className="text-center">No tasks available</p>
        )}
      </div>
    </div>
  );
};

export default App;
