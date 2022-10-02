import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import HomeView from '../views/HomeView.vue'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
  {
    path: '/',
    name: 'home',
    component: HomeView
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
