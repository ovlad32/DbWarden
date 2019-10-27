import Vue from "vue";
import Vuex from "vuex";
import Databases from "./databases";

Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    Databases
  }
});
