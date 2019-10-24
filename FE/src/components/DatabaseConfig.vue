<template>
  <section class="section is-full" style="background:lightyellow">
    <form class="databaseConfig">
      <div class="container">
        <div class="is-6" style>
          <div class="field is-horizontal">
            <div class="field-label is-normal">
              <label for="typeFormId" class="label">Type</label>
            </div>
            <div class="field-body">
              <div class="field">
                <p class="control is-expanded has-icons-left">
                  <span class="select">
                    <select id="typeFormId" class="select">
                      <option v-for="d in types" :key="d.type" :value="d.type" :label="d.name" />
                    </select>
                  </span>
                  <span class="icon is-small is-left">
                    <font-awesome-icon :icon="databaseTypeIcon" />
                    <!-- <i class="fas fa-database"></i> -->
                  </span>
                </p>
              </div>
            </div>
          </div>
          <div class="field is-horizontal">
            <div class="field-label is-normal">
              <label for="urlFormId" class="label">URI</label>
            </div>
            <div class="field-body">
              <p class="control is-expanded has-icons-left">
                <input id="urlFormId" class="input" type="text" placeholder size="50" />
                <span class="icon is-small is-left">
                  <font-awesome-icon :icon="urlIcon" />
                </span>
              </p>
            </div>
          </div>
          <div class="field is-horizontal">
            <div class="field-label is-normal">
              <label for="aliasFormId" class="label">Alias</label>
            </div>
            <div class="field-body">
              <p class="control is-expanded has-icons-left">
                <input class="input" id="aliasFormId" type="text" placeholder size="50" />
                <span class="icon is-small is-left">
                  <font-awesome-icon :icon="databaseConfigIcon" />
                </span>
              </p>
            </div>
          </div>
          <div class="field is-horizontal">
            <div class="field-label"></div>
            <div class="field-body">
              <div class="field is-grouped">
                <div class="control">
                  <button class="button is-primary" type="submit">Create DataSource</button>
                </div>
                <p class="control">
                  <a class="button is-light">Close</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </section>
</template>

<style>
.dialog {
  display: flex;
  background: blueviolet;
}
</style>


<script>
import {
  faFolder,
  faServer,
  faAsterisk
} from "@fortawesome/free-solid-svg-icons";
//import databaseConfig from "./components/Datasour.vue";
import { mapState, mapActions } from "vuex";
import databaseConfigAPI from "../api/databaseConfig";
export default {
  data() {
    return {
      databaseTypeIcon: faFolder,
      urlIcon: faServer,
      databaseConfigIcon: faAsterisk,
      types: []
    };
  },
  //computed: mapState({
  //types: state => state.databaseConfig.types
  //}),
  /*computed: {
    types() {
      return this.types_;
    }
  },*/

  created() {
    databaseConfigAPI.getTypes().then(r => {
      this.types = r.data;
      //alert(r.data);
    });
    //this.loadDatabaseTypes();
  },
  methods: {
    loadDatabaseTypes() {
      //this.$store.dispatch("databaseConfig/getTypes");
    }
  }
};
</script>

