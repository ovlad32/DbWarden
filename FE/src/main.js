import Vue from "vue";
import App from "./App.vue";
import Buefy from "buefy";
import "buefy/dist/buefy.css";

import { library } from "@fortawesome/fontawesome-svg-core";
import { dom } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon as fa } from "@fortawesome/vue-fontawesome";

require("./assets/style.css");
require("./assets/main.scss");

library.add(fas);
Vue.component("fa", fa);
dom.watch(); // This will kick of the initial replacement of i to svg tags and configure a MutationObserver

Vue.use(Buefy);

Vue.config.productionTip = false;

export const eventBus = new Vue();

new Vue({
  render: h => h(App)
}).$mount("#app");
