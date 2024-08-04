import axios from "axios";

const API_URL = "http://localhost:8080/task/api/v1";

export const fetchTasksApi = async () => {
  const response = await axios.get(`${API_URL}/all`);
  return response.data;
};

export const addTaskApi = async (newTask) => {
  const response = await axios.post(`${API_URL}/create`, newTask);
  return response.data;
};

export const updateTaskApi = async (id, updatedTask) => {
  const response = await axios.put(`${API_URL}/${id}`, updatedTask);
  return response.data;
};

export const deleteTaskApi = async (id) => {
  await axios.delete(`${API_URL}/${id}`);
};

export const deleteAllTasksApi = async () => {
  await axios.delete(`${API_URL}/delete/all`);
};

export const deleteCompletedTasksApi = async (completedTaskIds) => {
  await Promise.all(completedTaskIds.map((id) => axios.delete(`${API_URL}/${id}`)));
};
