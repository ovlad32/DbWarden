<template>
  <div>
    <b-alert>{{messages}}</b-alert>
  </div>
</template>

<script>
import { eventBus } from "./eventBus";

export default {
  created() {
    eventBus.$on("status-error");
    eventBus.$on("status-message");
    eventBus.$on("status-info");
  }
};
</script>
