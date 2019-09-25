<template>
  <div class="app">
    <h1>page2</h1>
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
  created: function() {
  },
  methods: {
    xxx( x = 22, y = 10) {
      return x + y
    }
  }
}
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
