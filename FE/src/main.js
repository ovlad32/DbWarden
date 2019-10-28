import Vue from "vue";
import VueRouter from "vue-router";
import Buefy from "buefy";
import "buefy/dist/buefy.css";
import "bulma-helpers/css/bulma-helpers.min.css";

import { library } from "@fortawesome/fontawesome-svg-core";
import { dom } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon as fa } from "@fortawesome/vue-fontawesome";

import routes from "./routes";
import App from "./App.vue";

require("./assets/style.css");
require("./assets/main.scss");

library.add(fas);
Vue.component("fa", fa);
dom.watch(); // This will kick of the initial replacement of i to svg tags and configure a MutationObserver

Vue.use(Buefy);

Vue.config.productionTip = false;

var router = new VueRouter(routes);
Vue.use(VueRouter);

export const eventBus = new Vue();

new Vue({
  render: h => h(App),
  router
}).$mount("#app");
