<template>
  <div class="box" ref="box">
    <ul class="border-bottom mb-1">
      <li class="d-inline-block">
        <img v-bind:src="iconFile" width="32px" height="32px" />
      </li>
      <li class="d-inline-block">
        <span class="pl-1 db-type">{{type}}</span>
      </li>
    </ul>
    <ul class="alias-section">
      <li class="icon">
        <fa icon="signal" :title="availableTitle" @click="checkAvailability(id)" />
      </li>
      <router-link class="alias" tag="li" :to="{name:'database-edit',params:{id}}">
        <a ref="#">{{alias}}</a>
      </router-link>
    </ul>

    <!--
            <li class="status">
        <fa icon="signal" :title="availableTitle" @click="checkAvailability(id)" />
      </li>
    -->
  </div>
</template>
<style scoped>
.box {
  display: inline-block;
  background-color: ivory;
  width: 10rem;
  height: 15rem;
  border-style: solid;
  border-width: 2px;
  border-color: lightgrey;
  border-radius: 2%;
  padding: 0.5rem;
}
.box:hover {
  border-style: outset;
}
.db-type {
  padding-left: 0.3rem;
  white-space: nowrap;
  font-size: 0.8rem;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
}

.alias,
.alias a {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  font-size: 0.75rem;
  background-color: aqua;
}

.alias-section li {
  display: inline-block;
}
.alias-section .icon {
  background-color: blueviolet;
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