<template>
  <section>
    <b-table
      :columns="columns"
      :data="rows"
      paginated="true"
      backend-pagination="true"
      backend-sorting="true"
    />
    <template v-slot:default="row">
      <b-table-column label="ID" field="id" sortable>{{row.id}}</b-table-column>
    </template>
  </section>
</template>

<script>
import DcApi from "../api/databaseConfig";

export default {
  data() {
    return {
      apiData: {},
      columns: [
        {
          field: "id",
          label: "ID",
          numeric: true
        }
      ]
    };
  },
  getters: {
    rows() {
      return this.apiData.content.map();
    }
  },
  created() {
    DcApi.get().then(reps => (this.apiData = resp.data));
  }
};
</script>