import api from "../api/databases";

const state = {
  types: [],
  items: []
};

const getters = {
  findById: state => id => {
    return state.items.find(item => item.id == id);
  }
};
const actions = {
  fetchTypes({ commit }) {
    api.getTypes().then(r => commit("putDbTypes", r.data));
  },
  fetchAll({ commit }, filters) {
    api.getAll(filters).then(r => commit("putDbs", r.data.content));
  },
  fetchById({ commit }, id) {
    api.getAll({ id: id }).then(r => commit("putDb", r.data.content));
  }
};

const mutations = {
  putDbTypes(state, data) {
    state.types = data;
  },
  putDbs(state, data) {
    state.items = data;
  },
  putDb(state, data) {
    if (data.id) {
      let index = state.items.findIndex(e => e.id === data.id);
      if (index > 0) {
        state.items[index] = data;
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
