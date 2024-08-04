import {
  fetchTasksApi,
  addTaskApi,
  updateTaskApi,
  deleteTaskApi,
  deleteAllTasksApi,
  deleteCompletedTasksApi
} from "../api/TaskApi";
import { toast } from "react-toastify";

const handleAxiosError = (error, defaultMessage) => {
  if (error.response) {
    const { validationErrors } = error.response.data;
    if (validationErrors && validationErrors.title) {
      toast.error(`${validationErrors.title}`);
    } else {
      toast.error(defaultMessage);
    }
  } else {
    toast.error("An unexpected error occurred.");
  }
};

const fetchTasks = async () => {
  try {
    return await fetchTasksApi();
  } catch (error) {
    handleAxiosError(error, "Error fetching tasks");
  }
};

const addTask = async (newTask) => {
  try {
    return await addTaskApi(newTask);
  } catch (error) {
    handleAxiosError(error, "Error adding task");
  }
};

const updateTask = async (id, updatedTask) => {
  try {
    return await updateTaskApi(id, updatedTask);
  } catch (error) {
    handleAxiosError(error, "Error updating task");
  }
};

const deleteTask = async (id) => {
  try {
    await deleteTaskApi(id);
  } catch (error) {
    handleAxiosError(error, "Error deleting task");
  }
};

const deleteAllTasks = async () => {
  try {
    await deleteAllTasksApi();
  } catch (error) {
    handleAxiosError(error, "Error deleting all tasks");
  }
};

const deleteCompletedTasks = async (completedTaskIds) => {
  try {
    await deleteCompletedTasksApi(completedTaskIds);
  } catch (error) {
    handleAxiosError(error, "Error deleting completed tasks");
  }
};

export default {
  fetchTasks,
  addTask,
  updateTask,
  deleteTask,
  deleteAllTasks,
  deleteCompletedTasks,
};
