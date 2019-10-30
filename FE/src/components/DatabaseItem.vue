<template>
  <div class="box">
    <div class="title">
      <img v-bind:src="iconFile" :title="type" width="32" height="32" />&nbsp;
      <p class="alias">{{alias}}</p>
    </div>
    <div class="dashboard">
      <router-link :to="{name:'database-edit',params:{id}}">
        <a class="icon is-small is-left">123</a>
      </router-link>
    </div>
    <div class="status"></div>
  </div>
</template>
<style scoped>
.box {
  display: flex;
  flex-direction: column;
  width: 10rem;
  height: 15rem;
  background-color: ivory;
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
import DcApi from "../api/databases";

export default {
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
    }
  },
  computed: {
    iconFile() {
      return DcApi.getIconFileName(this.type);
    }
  }
};
</script>