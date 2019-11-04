<template>
  <div class="message-bar">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">321</div>
  </div>
</template>

<style scoped>
.message-bar {
  position: relative;
  z-index: 10;
  max-height: 5rem;
}
</style>
<script>
/* */
import { eventBus } from "../eventBus";

export default {
  created() {
    eventBus.$on("status-error");
    eventBus.$on("status-message");
    eventBus.$on("status-info");
  }
};
</script>
