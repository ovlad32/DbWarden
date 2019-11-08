<template>
  <div class="app-box d-inline-block border border-solid p-2" ref="box">
    <ul class="border-bottom mb-1 text-nowrap">
      <li class="d-inline-block">
        <img class="logo" v-bind:src="iconFile" />
      </li>
      <li
        style="width: calc(100% - 32px);"
        class="d-inline-block pl-1 align-middle font-weight-bold text-truncate"
      >{{type}}</li>
    </ul>
    <ul class="text-nowrap">
      <li class="d-inline-block">
        <fa icon="signal" :title="availableTitle" @click="checkAvailability(id)" />
      </li>
      <router-link
        style="width: calc(100% - 1rem);"
        class="d-inline-block pl-1 text-truncate"
        t2ag="li"
        :to="{name:'database-edit',params:{id}}"
      >
        <a href="#">{{alias}} {{alias}}</a>
      </router-link>
    </ul>

    <ul>
      <li></li>
      <li></li>
    </ul>

    <!--
            <li class="status">
        <fa icon="signal" :title="availableTitle" @click="checkAvailability(id)" />
      </li>
    -->
  </div>
</template>
<style scoped>
.logo {
  width: var(--logo-width);
  height: var(--logo-width);
}
.app-box {
  --logo-width: 32px;
  height: 15rem;
  width: 10rem;
  background-color: ivory;
  border-radius: 1% !important;
  border-width: 2px !important;
  border-color: lightgrey;
}
.app-box:hover {
  border-style: outset;
}
.app-box li {
  vertical-align: middle;
}
.app-box a {
  text-decoration: none;
  font-size: 0.75rem;
  vertical-align: middle;
}
</style>
<script>
//  background-image: url("../assets/db-icons/oracle.svg");
//  background-position: center;
//  background-size: cover;
//  background-repeat: no-repeat;

import DbApi from "../api/databases";
import { fmt } from "../mixins";
import { mapActions } from "vuex";
import { eventBus } from "../eventBus";

export default {
  mixins: [fmt],
  props: {
    id: {
      type: Number,
      requited: true
    },
    type: {
      type: String,
      requited: true
    },
    alias: {
      type: String,
      requited: true
    },
    whenAvailable: {
      type: Number,
      requited: true
    }
  },

  mounted() {
    //this.$ref["box"].style[""]
    //this.item = this.findById(this.id);
  },
  computed: {
    iconFile() {
      return DbApi.getIconFileName(this.type);
    },
    availableTitle() {
      return "Last check at " + this.fullDateTime(this.whenAvailable);
    }
  },
  methods: {
    checkAvailability(id) {
      DbApi.checkAvailability(id).then(r => {
        if (r.data.errorMessages && r.data.errorMessages !== null) {
          Object.entries(r.data.errorMessages).forEach(([key, val]) => {
            eventBus.$emit("error", { key: key, message: val });
            //            this.error(val, key);
          });
        } else {
          this.fetchById(id);
        }
      });
    },
    ...mapActions("mDatabases", ["fetchById"]),
    ...mapActions("mMessages", ["error"])
  }
};
</script>