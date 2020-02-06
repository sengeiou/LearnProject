<template>
  <div class="app">
    <h1>page1</h1>
     <div>
      {{$store.state.count}}
    </div>  
  </div>
</template>

<script>
export default {
  name: "page2",
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  created() {},
  methods: {}
};
</script>
<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
