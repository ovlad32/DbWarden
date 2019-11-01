import Vue from "vue";
import Vuex from "vuex";
import mDatabases from "./databases";

Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    mDatabases
  }
});
