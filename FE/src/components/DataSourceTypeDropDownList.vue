<template>
  <select>
    <option
      v-for="dbt in payload"
      :key="dbt.databaseType"
      :value="dbt.databaseType"
      :label="dbt.databaseName"
    />
  </select>
</template>

<script>
export default {
  props: {
    payload: {
      type: Array,
      required: true
    }
  }
};
</script>