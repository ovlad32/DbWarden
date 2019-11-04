const state = {
  all: [],
  unread: false
};

const actions = {
  error({ commit }, data, key) {
    let msg = { type: "error", message: data, seen: false };
    if (key) {
      msg.key = key;
    }

    commit("putMessage", msg);
  },
  read({ commit }, msg) {
    commit("putReadFlag", msg);
  }
};

const getters = {
  getErrorCount: state => {
    return state.all.reduce((a, v) => {
      return a + (v.type === "error" ? 1 : 0);
    }, 0);
  },
  hasUnread: state => {
    state.unread;
  }
};

const mutations = {
  putMessage(state, data) {
    state.all.push(data);
  },
  putReadFlag(msg) {
    // this is simple but i guess it doesn't work
    msg.seen = true;
    state.unread = state.all.reduce((c, m) => (c + !m.seen ? 1 : 0), 0) > 0 > 0;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};
