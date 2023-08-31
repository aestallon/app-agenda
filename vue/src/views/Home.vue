<template>
  <p>Hello world!</p>
</template>

<script lang="ts" setup>
import { taskServiceKey } from "@/services";
import { inject } from "vue";
import TaskService from "@/services/task.service";

const taskService: TaskService | undefined = inject(taskServiceKey);
</script>
