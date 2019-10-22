import Vue from "vue";
import App from "./App.vue";
import VueResource from "vue-resource";

import { library } from "@fortawesome/fontawesome-svg-core";
import { faCoffee, faDatabase } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

//import '@fortawesome/fontawesome-free';

///* "bootstrap": "^4.3.1",*/

//import 'bootstrap/dist/css/bootstrap.min.css';
require("./assets/style.css");
require("./assets/main.scss");

library.add(faCoffee);
library.add(faDatabase);

Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.use(VueResource);

Vue.config.productionTip = false;

export const eventBus = new Vue();
new Vue({
  render: h => h(App)
}).$mount("#app");
