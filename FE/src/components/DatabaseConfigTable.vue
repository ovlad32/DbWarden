<template>
  <section>
    <b-table
      :data="rows"
      :paginated="paginated"
      :per-page="perPage"
      backend-pagination
      backend-sorting
      striped
      :total="total"
      hoverable
      detailed
      :show-detail-icon="showDetailIcon"
      icon-pack="fas"
    >
      <template v-slot:default="props">
        <b-table-column label="ID" field="id" sortable>{{props.row.id}}</b-table-column>
        <b-table-column label="Type" field="type" sortable>{{props.row.databaseType.type}}</b-table-column>
        <b-table-column label="Name" field="name" sortable>{{props.row.name}}</b-table-column>
        <b-table-column label="JDBC URI" field="url" sortable>{{props.row.url}}</b-table-column>
      </template>
    </b-table>
  </section>
</template>

<script>
import DcApi from "../api/databaseConfig";

export default {
  data() {
    return {
      rows: [],
      paginated: true,
      paginationSize: 0,
      perPage: 0,
      total: 0,
      showDetailIcon: true
    };
  },
  computed: {},
  mounted() {
    DcApi.getAll().then(resp => {
      var data = resp.data;
      this.rows = data.content;
      this.paginated = true;
      this.perPage = data.size;
      this.total = data.totalElements | 0;
    });
  }
};
</script>