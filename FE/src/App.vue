<template>
  <section>
    <nav-bar />

    <!-- <datasource-type-ddl :payload="databaseTypes"/> -->
    <!--<div class="mail-box">
            <app-sidebar :messages="messages"></app-sidebar>
            <app-content></app-content>
        </div>
    -->
    <!-- <button class="button is-primary">primary button</button> -->
    <!-- <font-awesome-icon icon="coffee" style="color: Tomato" /> 
         <font-awesome-icon icon="database" style="color: Tomato" /> 
         <i class="fa fa-coffee"/>
         <i class="fas fa-database" style="color:blue;"/>
    -->
    <router-view></router-view>
    <!--<database-config />
    <database-config-table />
    <database-config-detail service-user="admin" updated="12/19/2015" status="available" />
    -->
  </section>
</template>

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
//import databaseTypes from "./data/databaseTypes.js";
import store from "./store/index";

export default {
  name: "DbWatcher",
  components: {
    // "datasource-type-ddl":dataSourceTypeDDL,
    //"database-config": databaseConfig,
    //"database-config-table": databaseConfigTable,
    //databaseConfigDetail,
    "nav-bar": navBar
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
