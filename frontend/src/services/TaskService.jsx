import {
  fetchTasksApi,
  addTaskApi,
  updateTaskApi,
  deleteTaskApi,
  deleteAllTasksApi,
  deleteCompletedTasksApi
} from "../api/TaskApi";
import { toast } from "react-toastify";

// Function to handle Axios errors and display appropriate toast notifications
const handleAxiosError = (error, defaultMessage) => {
  if (error.response) {
    const { data } = error.response;
    if (data) {
      if (data.validationErrors && data.validationErrors.title) {
        toast.error(`${data.validationErrors.title}`);
      } else if (data.message) {
        toast.error(`${data.message}`);
      } else {
        toast.error(defaultMessage);
      }
    } else {
      toast.error(defaultMessage);
    }
  } else {
    toast.error("An unexpected error occurred.");
  }
};// End Method

// Function to fetch tasks using the API
const fetchTasks = async () => {
  try {
    return await fetchTasksApi();
  } catch (error) {
    handleAxiosError(error, "Error fetching tasks");
  }
};// End Method

// Function to add a new task using the API
const addTask = async (newTask) => {
  try {
    return await addTaskApi(newTask);
  } catch (error) {
    handleAxiosError(error, "Error adding task");
  }
};// End Method

// Function to update an existing task using the API
const updateTask = async (id, updatedTask) => {
  try {
    return await updateTaskApi(id, updatedTask);
  } catch (error) {
    handleAxiosError(error, "Error updating task");
  }
};// End Method

// Function to delete a task using the API
const deleteTask = async (id) => {
  try {
    await deleteTaskApi(id);
  } catch (error) {
    handleAxiosError(error, "Error deleting task");
  }
};// End Method

// Function to delete all tasks using the API
const deleteAllTasks = async () => {
  try {
    await deleteAllTasksApi();
  } catch (error) {
    handleAxiosError(error, "Error deleting all tasks");
  }
};// End Method

// Function to delete all completed tasks using the API
const deleteCompletedTasks = async (completedTaskIds) => {
  try {
    await deleteCompletedTasksApi(completedTaskIds);
  } catch (error) {
    handleAxiosError(error, "Error deleting completed tasks");
  }
};// End Method

// Exporting functions for use in other parts of the application
export default {
  fetchTasks,
  addTask,
  updateTask,
  deleteTask,
  deleteAllTasks,
  deleteCompletedTasks,
};// End Export
