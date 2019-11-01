<template>
  <div class="box" ref="box">
    <div class="title">
      <img v-bind:src="iconFile" :title="item.type" width="32" height="32" />&nbsp;
      <p class="alias">{{item.alias}}</p>
    </div>
    <div class="dashboard">
      <router-link :to="{name:'database-edit',params:{id}}">
        <a class="icon is-small is-left">123</a>
      </router-link>
    </div>
    <div class="status">
      <fa icon="signal" :title="availableTitle" @click="checkAvailability(id)" />
    </div>
  </div>
</template>
<style scoped>
.box {
  background-color: ivory;
  display: flex;
  flex-direction: column;
  width: 10rem;
  height: 15rem;
  border-style: solid;
  border-width: 2px;
  border-color: lightgray;
  border-radius: 10%;
  padding: 0.8rem;
}
.box:hover {
  border-style: outset;
}
.title {
  display: flex;
  border-bottom: 1px solid lightgray;
  padding-bottom: 0.5rem;
}
.title img {
  display: inline;
}

.title .alias {
  align-self: center;
  flex-grow: 1;
  white-space: nowrap;
  font-size: 0.8rem;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
}
.dashboard {
}
</style>
<script>
//  background-image: url("../assets/db-icons/oracle.svg");
//  background-position: center;
//  background-size: cover;
//  background-repeat: no-repeat;

import DbApi from "../api/databases";
import { fmt } from "../mixins";
import { mapGetters, mapActions } from "vuex";

export default {
  mixins: [fmt],
  props: {
    id: {
      type: Number,
      requited: true
    }
  },
  data() {
    return {
      item: {
        type: null,
        alias: null,
        whenAvailable: null
      }
    };
  },
  /*,
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
    }*/

  mounted() {
    //this.$ref["box"].style[""]
    this.item = this.findById(this.id);
  },
  computed: {
    iconFile() {
      return DbApi.getIconFileName(this.item.type);
    },
    availableTitle() {
      return "Last check at " + this.fullDateTime(this.item.whenAvailable);
    },
    ...mapGetters("mDatabases", ["findById"])
  },
  methods: {
    checkAvailability(id) {
      DbApi.checkAvailability(id);
    },
    ...mapActions("mDatabases", ["fetchById"])
  }
};
</script>