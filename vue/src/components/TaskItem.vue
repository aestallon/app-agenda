<script setup lang="ts">
import { Task } from "@/api/agenda";

const props = defineProps<{ task: Task }>();

const title: string = props.task.title;
const description: string = props.task.description ?? "";
</script>

<template>
  <v-card variant="outlined">
    <v-checkbox
      v-model="task.completed"
      @change="$emit('dataChanged', task)"
    ></v-checkbox>
    <v-card-title>{{ title }}</v-card-title>
    <v-card-content>{{ description }}</v-card-content>
    <v-card-actions>
      <v-btn @click="$emit('deleted', task)">Delete</v-btn>
    </v-card-actions>
  </v-card>
</template>
