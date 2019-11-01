<template>
  <div class="container d-flex flex-column w-100">
    <nav-bar />
    <router-view></router-view>
    <status-bar />
  </div>
</template>
<style scoped>
</style>
<script>
/*import Sidebar from './components/Sidebar.vue';
    import Content from './components/Content.vue';

    import messages from './data/messages';
    */
// import dataSourceTypeDDL from './components/DataSourceTypeDropDownList.vue';
//import databaseConfig from "./components/DatabaseConfig.vue";
//import databaseConfigDetail from "./components/DatabaseConfigDetail.vue";
//import databaseConfigTable from "./components/DatabaseConfigTable.vue";
import navBar from "./components/NavBar.vue";
import statusBar from "./components/StatusBar.vue";
//import databaseTypes from "./data/databaseTypes.js";
import store from "./store/index";

export default {
  name: "DbWatcher",
  components: {
    // "datasource-type-ddl":dataSourceTypeDDL,
    //"database-config": databaseConfig,
    //"database-config-table": databaseConfigTable,
    //databaseConfigDetail,
    "nav-bar": navBar,
    "status-bar": statusBar
    //   appSidebar: Sidebar,
    //  appContent: Content
  },
  /*
  ,
  created() {
    loadDatabaseTypes().then(result => (databaseTypes = response));
  }
  methods: {
    loadDatabaseTypes() {
      return this.$http.get("http://localhost:3001/dict/datatypes").then(
        response => {
          response.json();
        },
        response => alert("could not load database type list")
      );
    }
  },*/
  store
};
</script>
