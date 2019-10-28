<template>
  <div class="box">
    <p class="title">{{name}}</p>
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
.box:hover {
  border-style: outset;
  border-width: 2px;
}

.title {
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
    name: {
      type: String,
      requited: true
    }
  }
};
</script>