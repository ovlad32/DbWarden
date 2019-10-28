<template>
  <div class="box">
    <img v-bind:src="icon" :title="dbType" />&nbsp;
    <p class="title">{{dbName}}</p>
  </div>
</template>
<style scoped>
.box {
  width: 10em;
  height: 13em;
  border-style: solid;
  border-width: 2px;
  border-color: rgb(200, 200, 168);
  border-radius: 10%;
  margin: 1em;
  background-color: ivory;
  padding: 0.8em;
}
.box .logo {
  display: inline;
}
.box:hover {
  border-style: outset;
  border-width: 2px;
}

.title {
  display: inline;
  white-space: nowrap;
  font-size: 0.8em;
  font-weight: bold;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
<script>
export default {
  props: {
    dbType: {
      type: String,
      requited: true
    },
    dbName: {
      type: String,
      requited: true
    }
  },
  computed: {
    icon() {
      //var pathToIcons = "../assets/db-icons/";
      var iconfile = "";
      switch (this.dbType) {
        case "ORACLE":
          iconfile = "oracle.svg";
          break;
        case "SYBASE":
          iconfile = "sybase.svg";
          break;
        default:
          iconfile = "default.svg";
          break;
      }
      return require(`@/assets/db-icons/${iconfile}`);
    }
  }
};
</script>