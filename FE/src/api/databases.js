import axios from './internals/transport';

export default {
	fetchTypes() {
		return axios.get('databases/types').catch((e) => {
			throw new Error('Could not retrieve datasource types: ' + e);
		});
	},

	fetchDatabases(filters) {
		return axios({
			method: 'GET',
			url: 'databases',
			params: filters
		}).catch((e) => {
			throw new Error('Could not retrieve database configurations: ' + e);
		});
	},
	fetchDatabasesGroupedByType(filters) {
		return axios({
			method: 'GET',
			url: 'databases/groupedByType',
			params: filters
		}).catch((e) => {
			throw new Error('Could not retrieve database configurations: ' + e);
		});
	},

	/*
	checkAvailability(id) {
		return api({
			method: 'POST',
			url: 'databases/check',
			data: { id }
		}).catch((e) => {
			throw new Error('Could not check database availability: ' + e);
		});
	},
	checkParams(item) {
		return api({
			method: 'POST',
			url: 'databases/test',
			data: item
		});
	},
	save(item) {
		return api({
			method: 'POST',
			url: 'databases',
			data: item
		});
	},
	*/
	getIconFileName(dbType) {
		let iconfile = '';
		switch (dbType) {
			case 'MSSQL':
				iconfile = 'oracle.svg';
				break;
			case 'SYBASE':
				iconfile = 'sybase.svg';
				break;
			default:
				iconfile = 'default.svg';
				break;
		}
		return require(`@/assets/db-icons/${iconfile}`);
	}
};
