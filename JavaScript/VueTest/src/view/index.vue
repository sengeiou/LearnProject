<template>
  <div class="app">
    <div><router-link :to="{ name: 'page1', params: {  }}">Page1</router-link></div>
    <div><router-link :to="{ name: 'page2', params: {  }}">Page2</router-link></div>
  </div>
</template>

<script>
export default {
  name: 'index'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
