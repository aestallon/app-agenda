import axios, { type AxiosInstance } from "axios";
import { AgendaApi, Configuration } from "../api/agenda";
import TaskService from "./task.service";

const instance: AxiosInstance = axios.create();
instance.interceptors.request.use((config) => {
  const token: string | null = localStorage.getItem("jwtToken");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

const prefix: string = "/api";
const configuration: Configuration = new Configuration();

const agendaApi: AgendaApi = new AgendaApi(configuration, prefix, instance);

export const taskService: TaskService = new TaskService(agendaApi);

export * from "./keys";
export * from './task.service';
