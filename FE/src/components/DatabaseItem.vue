<template>
  <div class="box">
    <div class="logo">
      <img v-bind:src="item.iconFile" :title="item.type" width="32" height="32" />&nbsp;
      <p class="title">{{item.name}}</p>
    </div>
    <div class="dashboard">
      <router-link :to="{name:'database-edit',params:{id:item.id}}">
        <a class="icon is-small is-left" />
      </router-link>
    </div>
    <div class="status"></div>
  </div>
</template>
<style scoped>
.box {
  display: flex;
  flex-direction: column;
  width: 10em;
  height: 13em;
  background-color: ivory;
  border-style: solid;
  border-width: 2px;
  border-color: lightgray;
  border-radius: 10%;
  margin: 1em;
  padding: 0.8em;
}
.box:hover {
  border-style: outset;
}
.logo {
  display: flex;
  border-bottom: 1px solid lightgray;
  padding-bottom: 0.5em;
}
.logo img {
  display: inline;
}

.logo .title {
  align-self: center;
  flex-grow: 1;
  white-space: nowrap;
  font-size: 0.8em;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
}
.dashboard {
}
</style>
<script>
export default {
  props: {
    item: {
      type: Object,
      requited: true
    }
  }
};
</script>