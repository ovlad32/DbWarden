import dbAPI from '../api/databases';

const state = {
	types: [],
	typeIcons: {},
	databases: [],
	dbByType: []
};

const getters = {
	allTypes: (state) => state.types,
	all: (state) => state.databases,
	typeIcons: (state) => state.typeIcons,
	dbByType: (state) => state.dbByType,

	findById: (state) => (id) => {
		return state.databases.find((db) => db.id == id);
	}
};

const actions = {
	initTypes(context, payload) {
		if (!state.types.length || (!!payload && payload.forcibly)) {
			dbAPI.fetchTypes().then((r) => {
				context.commit('store-types', r.data.rows);
				r.data.rows.forEach((row) => {
					context.commit('store-icon', { type: row.type, resource: dbAPI.getIconFileName(row.type) });
				});
			});
		}
	},

	initAll(context) {
		dbAPI.fetch().then((r) => {
			let dbByType = [];
			r.data.rows.forEach((e) => {
				for (let t of dbByType) {
					if (t[0].type === e.type) {
						t.push(e);
						return;
					}
				}
				dbByType.push([ e ]);
			});
			context.commit('store-all', r.data.rows);
			context.commit('store-by-type', dbByType);
		});
	}

	/*	fetchAll({ commit }, filters) {
		api.getAll(filters).then((r) => commit('putDbs', r.data.content));
	},
	fetchById({ commit }, id) {
		api.getAll({ id: id }).then((r) => commit('putDb', r.data.content));
	}*/
};

const mutations = {
	'store-types'(state, data) {
		state.types = data;
	},

	'store-all'(state, data) {
		state.databases = data;
	},
	'store-by-type'(state, data) {
		state.dbByType = data;
	},
	'store-icon'(state, data) {
		state.typeIcons[data.type] = data.resource;
	}
};
export default {
	namespaced: true,
	state,
	mutations,
	getters,
	actions
};
