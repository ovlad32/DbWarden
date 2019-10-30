<template>
  <div class="d-flex flex-column flex-grow-1 overflow-y-scroll">
    <router-link :to="{name:'database-new'}" class="ml-auto my-2 button is-primary">New Database</router-link>

    <div class="flex-grow-1">
      <!--
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
          <b-table-column label="Type" field="type" sortable>{{props.row.type}}</b-table-column>
          <b-table-column label="Name" field="name" sortable>{{props.row.name}}</b-table-column>
          <b-table-column label="JDBC URI" field="url" sortable>{{props.row.url}}</b-table-column>
        </template>
      </b-table>
            
      -->
      <database-item v-for="item in items" v-bind:key="item.id" v-bind="item" />
    </div>
  </div>
</template>
<style scoped>
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
      items: [],
      paginated: true,
      paginationSize: 0,
      perPage: 0,
      total: 0,
      showDetailIcon: true
    };
  },
  mounted() {
    DcApi.getAll().then(resp => {
      let data = resp.data;
      this.items = data.content;
      this.paginated = true;
      this.perPage = data.size;
      this.total = data.totalElements | 0;
    });
  }
};
</script>