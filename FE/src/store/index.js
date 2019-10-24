import Vue from "vue";
import Vuex from "vuex";
import databaseConfig from "./databaseConfig";

Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    databaseConfig
  }
});
