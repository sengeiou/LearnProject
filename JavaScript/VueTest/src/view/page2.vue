<template>
  <div class="app">
    <h1>page2</h1>
    <div>
      {{ name }}
    </div>
    <div>
      {{ count }}
    </div>

    <div>
      从属性访问$store.getters.doneList ===》 {{ $store.getters.doneList }}
    </div>
    <h3>从辅助函数...mapGetters(['doneList'])中获取的 ===》{{ doneList }}</h3>

    <button @click="countAdd">countAdd</button>
    <button @click="countPlus">countPlus</button>
  </div>
</template>

<script>
import { mapState, mapGetters ,mapMutations} from "vuex";

export default {
  name: "page2",
  computed: {
    name() {
      return this.msg.replace("Vue", "cocoa");
    },
    ...mapGetters(["doneList"]),
    ...mapState(["count"]) // ... 扩展符号
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  created: function() {
     this.$store.commit('countPlus')
  },
  methods: {
    ...mapMutations(['countPlus']),
    countAdd(){
      this.$store.commit('countPlus')
    }
  }
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
