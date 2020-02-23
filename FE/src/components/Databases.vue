<template>
  <div class="d-flex flex-column flex-grow-1 overflow-y-scroll">
    <router-link :to="{name:'database-new'}" class="ml-auto my-2 btn btn-primary">New Database</router-link>

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
      <div v-for="td in dbByType" v-bind:key="td[0].type">
        <div>
          <img class="vendor-logo" v-bind:src="typeIcons[td[0].type]" />
          <span>{{td[0].type_name}}</span>
        </div>
        <database-item v-for="db in td" v-bind:key="db.id" v-bind:db="db" />
      </div>
    </div>
  </div>
</template>
<style scoped>
.var {
  --logo-width: 32px;
}
.vendor-logo {
  width: var(--logo-width);
  height: var(--logo-width);
}
</style>
<script>
import { mapGetters } from "vuex";
import DatabaseItem from "./DatabaseItem.vue";

export default {
  components: {
    DatabaseItem
  },
  computed: {
    ...mapGetters({
      dbs: "db-store/all",
      dbByType: "db-store/dbByType",
      typeIcons: "db-store/typeIcons"
    }),
    dbByType() {
      let result = [];
      //  debugger;
      this.dbs.forEach(e => {
        for (let t of result) {
          if (t[0].type === e.type) {
            t.push(e);
            return;
          }
        }
        result.push([e]);
      });
      return result;
    }
  },

  mounted() {
    this.$store.dispatch("db-store/initTypes");
    this.$store.dispatch("db-store/initAll");
  }
};
</script>