import TaskService from "./task.service";
import type { InjectionKey } from "vue";

export const taskServiceKey: InjectionKey<TaskService> =
  Symbol() as InjectionKey<TaskService>;
