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
      <div v-for="r in dbGroupedByType" v-bind:key="r.type">
        <div class="database-type">
          <img class="type-logo" v-bind:src="typeIcons[r.type]" />
          <span class="type-name">{{r.name}}</span>
        </div>
        <database-item v-for="d in r.c_databases" v-bind:key="d.id" v-bind:db="d" />
      </div>
    </div>
  </div>
</template>
<style scoped>
.var {
  --logo-width: 64px;
}
.type-logo {
  width2: var(--logo-width);
  width:48px;
  height: 48px;
  padding: 0.2rem;
}
.type-name{
  
}
.database-type{
  background-color: #eee;
  font-size: 1.2rem;
  padding: .2rem 0;
  margin: .5rem 0 .1rem 0;
}
.type-name {
  font-weight: bold;

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
      dbGroupedByType: "db-store/dbGroupedByType",
      typeIcons: "db-store/typeIcons"
    })
    /*dbGroupedByType() {
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
    }*/
  },

  mounted() {
    this.$store.dispatch("db-store/initTypes");
    this.$store.dispatch("db-store/initDatabasesGroupedByType");
  }
};
</script>