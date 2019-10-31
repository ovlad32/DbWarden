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
    api.getAll(filters).then(r => commit("putDbs", r.data));
  },
  getById({ commit }, id) {
    api.getAll({ id: id }).then(r => commit("putDb", r.data));
  }
};

const mutations = {
  putDbTypes(state, data) {
    state.types = data;
  },
  putDbs(store, data) {
    store.databases = data;
  },
  putDb(store, data) {
    if (data.id) {
      let index = store.databases.findIndex(e => e.id === data.id);
      if (index > 0) {
        store.databases[index] = data;
      }
    }
  }
};
export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};
