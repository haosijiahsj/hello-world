import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Registry from '@/pages/Registry'
import Main from '@/pages/Main'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'Main',
      component: Main
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/registry',
      name: 'Registry',
      component: Registry
    }
  ]
})
