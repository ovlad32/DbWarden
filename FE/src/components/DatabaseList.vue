<template>
  <div class="has-padding-5">
    <div class="columns">
      <div class="column"></div>
      <div class="column is-one-quarter">
        <button class="button is-pulled-right is-primary">New Database</button>
      </div>
    </div>
    <div class="columns is-vcentered">
      <div class="column">
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
      </div>
    </div>
  </div>
</template>
<style scoped>
.ds-content {
  padding: 0.3em;
}
.ds-table {
  align-self: stretch;
  background-color: aqua;
}
</style>
<script>
import DcApi from "../api/databases";

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