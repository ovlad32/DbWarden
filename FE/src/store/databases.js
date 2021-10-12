import dbAPI from '../api/databases';

const state = {
	types: [],
	typeIcons: {},
	databases: [],
	dbGroupedByType: []
};

const getters = {
	types: (state) => state.types,
	databases: (state) => state.databases,
	typeIcons: (state) => state.typeIcons,
	dbGroupedByType: (state) => state.dbGroupedByType,

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

	initDatabases(context) {
		dbAPI.fetchDatabases().then((r) => {
			context.commit('store-databases', r.data.rows);
		});
	},
	initDatabasesGroupedByType(context) {
		dbAPI.fetchDatabasesGroupedByType().then((r) => {
			context.commit('store-db-grouped-by-type',  r.data.rows);
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

	'store-databases'(state, data) {
		state.databases = data;
	},
	'store-db-grouped-by-type'(state, data) {
		state.dbGroupedByType = data;
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
