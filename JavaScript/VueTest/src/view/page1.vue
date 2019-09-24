<template>
  <div class="app">
    <h1>page1</h1>
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
    console.log(letapp.name)
    console.log(constapp.name)
    console.log(this.test1() +" // 可以看到let是在块级作用域中") 

    let isDone : boolean = false

    

  },
  methods: {
     test1() {
      let aaa = 10
      if(aaa > 0) {
        let aaa = 11111
      }
      return aaa
    }
  }
}
let letapp = {name :'let'}
const constapp = {name:"const"}

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
