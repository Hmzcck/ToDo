import axios from "axios";

// Base URL for the API
const API_URL = "http://localhost:8080/task/api/v1";

// Function to fetch all tasks from the API
export const fetchTasksApi = async () => {
  const response = await axios.get(`${API_URL}/all`);
  return response.data;
};// End Method

// Function to add a new task to the API
export const addTaskApi = async (newTask) => {
  const response = await axios.post(`${API_URL}/create`, newTask);
  return response.data;
};// End Method

// Function to update an existing task in the API
export const updateTaskApi = async (id, updatedTask) => {
  const response = await axios.put(`${API_URL}/${id}`, updatedTask);
  return response.data;
};// End Method

// Function to delete a task from the API
export const deleteTaskApi = async (id) => {
  await axios.delete(`${API_URL}/${id}`);
};// End Method

// Function to delete all tasks from the API
export const deleteAllTasksApi = async () => {
  await axios.delete(`${API_URL}/delete/all`);
};// End Method

// Function to delete completed tasks from the API
export const deleteCompletedTasksApi = async (completedTaskIds) => {
  await Promise.all(completedTaskIds.map((id) => axios.delete(`${API_URL}/${id}`)));
};// End Method
