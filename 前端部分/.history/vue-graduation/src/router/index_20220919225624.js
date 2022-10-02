import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import Shopping from '../views/Shopping.vue'
import HomeView from '../views/UserCenter.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
  {
    path: '/shopping',
    name: 'Shopping',
    component: Shopping
  },
  {
    path: '/',
    name: 'home',
    component: HomeView
  },

]

const router = new VueRouter({
  routes
})

export default router
