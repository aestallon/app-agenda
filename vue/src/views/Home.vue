<script lang="ts" setup>
import { taskServiceKey } from "@/services";
import { inject, ref } from "vue";
import { Task } from "@/api/agenda";
import TaskService from "@/services/task.service";
import { onMounted } from "vue";
import TaskItem from "@/components/TaskItem.vue";

const taskService: TaskService | undefined = inject(taskServiceKey);

const tasks = ref<Task[]>([]);

const newTask = ref<Task>({
  title: "",
  completed: false,
  important: false,
});
const showDialog = ref<boolean>(false);

onMounted(async () => {
  await taskService?.getAll();
  tasks.value = taskService?.tasks ?? [];
});

async function onDataChanged(event: any) {
  await taskService?.update(event as Task);
  tasks.value = taskService?.tasks ?? [];
}

async function onTaskCreation(event: any) {
  await taskService?.create(newTask.value);
  tasks.value = taskService?.tasks ?? [];
  showDialog.value = false;

  newTask.value = {
    title: "",
    completed: false,
    important: false,
  };
}

async function onTaskDeleted(event: any) {
  await taskService?.delete((event as Task)!.id!);
  tasks.value = taskService?.tasks ?? [];
}
</script>

<template>
  <h1>Agenda</h1>
  <div v-for="task in tasks">
    <TaskItem :task="task" @data-changed="onDataChanged" @deleted="onTaskDeleted"></TaskItem>
  </div>
  <v-btn rounded @click="showDialog = true">New</v-btn>

  <v-dialog v-model="showDialog">
    <v-sheet>
      <v-form validate-on="submit lazy" @submit.prevent="onTaskCreation">
        <v-text-field v-model="newTask.title" label="Cím"></v-text-field>
        <v-text-field
          v-model="newTask.description"
          label="Leírás"
        ></v-text-field>
        <v-btn type="submit" block text="Create"></v-btn>
      </v-form>
      <v-btn @click="showDialog = false">Close</v-btn>
    </v-sheet>
  </v-dialog>
</template>
