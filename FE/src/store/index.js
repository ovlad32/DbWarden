import Vue from 'vue';
import Vuex from 'vuex';
import dbStore from './databases';
import msgStore from './messages';
//import { monthsShort } from 'moment-timezone';

Vue.use(Vuex);
export default new Vuex.Store({
	modules: {
		'db-store': dbStore,
		'msg-store': msgStore
	}
});
