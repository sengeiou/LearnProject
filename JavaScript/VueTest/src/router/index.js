import Vue from 'vue'
import Router from 'vue-router'
import Index from '../view/index.vue'
import Page2 from '../view/page2.vue'
import Page1 from '../view/page1.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/page1',
      name: 'page1',
      component: Page1
    },
    {
      path: '/page2',
      name: 'page2',
      component: Page2
    }
  ]
})
