import api from "../api/databaseConfig";

const state = {
  types: []
};
const getters = {};
const actions = {
  getTypes({ commit }) {
    api.getTypes(resp => commit("putTypes", resp.data));
  }
};

const mutations = {
  putTypes(state, data) {
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
