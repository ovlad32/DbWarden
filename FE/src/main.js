import Vue from 'vue';

import VueRouter from 'vue-router';
Vue.use(VueRouter);

import VueMoment from 'vue-moment';
import moment from 'moment-timezone';

Vue.use(VueMoment, {
	moment
});

import BootstrapVue from 'bootstrap-vue';
Vue.use(BootstrapVue);

//import Buefy from "buefy";
//import "buefy/dist/buefy.css";
//import "bulma-helpers/css/bulma-helpers.min.css";

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

import { library } from '@fortawesome/fontawesome-svg-core';
import { dom } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
library.add(fas);
dom.watch(); // This will kick of the initial replacement of i to svg tags and configure a MutationObserver

import { FontAwesomeIcon as fa } from '@fortawesome/vue-fontawesome';
Vue.component('fa', fa);

import routes from './routes';
//import { mixedTypeAnnotation } from "babel-types";

require('./assets/style.css');
require('./assets/main.scss');

/*
Vue.use(Buefy, {
  defaultIconPack: "fas"
});
*/

//export const eventBus = new Vue();

import App from './App.vue';
Vue.config.productionTip = false;

const router = new VueRouter(routes);

const dbWarden = new Vue({
	render: (h) => h(App),
	router
}).$mount('#app');
