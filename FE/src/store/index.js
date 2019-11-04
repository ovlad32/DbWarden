import Vue from "vue";
import Vuex from "vuex";
import mDatabases from "./databases";
import mMessages from "./messages";

Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    mDatabases,
    mMessages
  }
});
