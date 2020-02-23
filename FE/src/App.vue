<template>
  <div class="container d-flex flex-column w-100">
    <nav-bar />
    <router-view></router-view>
  </div>
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
import { mapActions } from "vuex";
//import statusBar from "./components/StatusBar.vue";
///<status-bar />

//import databaseTypes from "./data/databaseTypes.js";
import store from "./store/index";
import { eventBus } from "./eventBus";

export default {
  name: "DbWatcher",
  components: {
    // "datasource-type-ddl":dataSourceTypeDDL,
    //"database-config": databaseConfig,
    //"database-config-table": databaseConfigTable,
    //databaseConfigDetail,
    "nav-bar": navBar
    //,  "status-bar": statusBar
    //   appSidebar: Sidebar,
    //  appContent: Content
  },
  created() {
    eventBus.$on("error", event => {
      this.error(event);
      this.$bvToast.toast(event.message, {
        variant: "warning",
        autoHideDelay: 3000,
        appendToast: true,
        toaster: "b-toaster-top-center",
        solid: true
      });
    });
  },
  methods: {
    ...mapActions("msg-store", ["error"])
  },
  store
};
</script>
