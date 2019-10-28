<template>
  <div class="hero is-padding-7 is-fullheight">
    <div class="hero-header navbar">
      <div class="navbar-end">
        <div class="navbar-item">
          <button class="button is-primary">New Database</button>
        </div>
      </div>
    </div>
    <div class="hero-body">
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
      >
        <template v-slot:default="props">
          <b-table-column label="ID" field="id" sortable>{{props.row.id}}</b-table-column>
          <b-table-column label="Type" field="type" sortable>{{props.row.databaseType.type}}</b-table-column>
          <b-table-column label="Name" field="name" sortable>{{props.row.name}}</b-table-column>
          <b-table-column label="JDBC URI" field="url" sortable>{{props.row.url}}</b-table-column>
        </template>
      </b-table>
    </div>
    <database-item
      v-for="r in rows"
      v-bind:key="r.id"
      :dbName="r.name"
      :dbType="r.databaseType.type"
    />
  </div>
</template>
<style scoped>
.db-view {
  display: inherit;
  flex: 1;
  padding: 0.3em;
  align-self: stretch;
}

.ds-list {
  align-self: stretch;
  background-color: aqua;
}
</style>
<script>
import DcApi from "../api/databases";
import DatabaseItem from "./DatabaseItem.vue";
export default {
  components: {
    DatabaseItem
  },
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