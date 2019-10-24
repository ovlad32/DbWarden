import api from "../api/databaseConfig";

const state = {
  types: []
};
const getters = {};
const actions = {
  getTypes({ commit }) {
    api.getTypes().then(r => commit("storeTypes", r.data));
  }
};

const mutations = {
  storeTypes(state, data) {
    state.types = data;
  }
};
export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};
