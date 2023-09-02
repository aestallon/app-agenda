import { AgendaApi, Task } from "@/api/agenda";

export default class TaskService {
  tasks: Task[] = [];

  constructor(private agendaApi: AgendaApi) {}

  async getAll(): Promise<void> {
    await this.agendaApi
      .getAllTasks()
      .then(
        (success) => {
          this.tasks = success.data;
        },
        (error) => {
          console.log(error);
          this.tasks = [
            {
              id: 0,
              title: "ApiError",
              description: "Something went wrong",
              important: false,
              completed: false,
            },
          ];
        }
      )
      .catch((e) => {
        console.log(e);
      });
  }

  async delete(id: number): Promise<void> {
    await this.agendaApi.deleteTask(id).then(
      (success) => {
        this.tasks = this.tasks.filter((t) => t.id !== id);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  async create(task: Task): Promise<void> {
    await this.agendaApi.createTask(task).then(
      (success) => {
        this.tasks.push(success.data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  async update(task: Task): Promise<void> {
    console.log('update', task);
    await this.agendaApi.updateTask(task.id!, task).then(
      (success) => {
        const nuTask: Task = success.data;
        task.completed = nuTask.completed;
        task.title = nuTask.title;
        task.description = nuTask.description;

        return task;
      },
      (error) => {
        console.log(error);
        task = this.tasks.find(t => t.id === task.id)!

        return task;
      }
    )
  }
}
