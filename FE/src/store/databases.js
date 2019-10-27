import api from "../api/databases";

const state = {
  types: [],
  databases: []
};
const getters = {};
const actions = {
  getTypes({ commit }) {
    api.getTypes().then(r => commit("putDbTypes", r.data));
  },
  getAll({ commit }, filters) {
    api.getAll(filters).then(r => commit("putDb", r.data));
  }
};

const mutations = {
  putDbTypes(state, data) {
    state.types = data;
  },
  putDb(store, data) {
    store.databases = data;
  }
};
export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};
