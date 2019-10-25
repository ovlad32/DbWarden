import api from "../api/databaseConfig";

const state = {
  types: [],
  databaseConfigs: []
};
const getters = {};
const actions = {
  getTypes({ commit }) {
    api.getTypes().then(r => commit("storeTypes", r.data));
  },
  get({ commit }, filters) {
    api
      .getDatabaseComfigs(filters)
      .then(r => commit("storeDatabaseConfigs", r.data));
  }
};

const mutations = {
  storeTypes(state, data) {
    state.types = data;
  },
  storeDatabaseConfigs(store, data) {
    store.databaseConfigs = data;
  }
};
export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};
