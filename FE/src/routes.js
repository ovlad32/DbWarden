import Databases from './components/Databases.vue';
import DatabaseEdit from './components/DatabaseEdit.vue';

const routes = [
	{ title: 'Database watcher - Home', path: '/', redirect: '/databases' },
	{
		name: 'databases',
		path: '/databases',
		component: Databases
	},
	{
		name: 'database-new',
		path: '/databases/new',
		component: DatabaseEdit
	},
	{
		name: 'database-edit',
		path: '/databases/:id',
		component: DatabaseEdit,
		props: true
	}
];

export default {
	routes
};
