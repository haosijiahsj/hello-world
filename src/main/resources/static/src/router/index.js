import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/pages/Login'
import Registry from '@/pages/Registry'
import Main from '@/pages/Main'
import DashBoard from '@/pages/DashBoard'
import UserQuery from '@/pages/user/Query'
import UserCreate from '@/pages/user/Create'
import UserEdit from '@/pages/user/edit'

Vue.use(Router)

let routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/registry',
    name: 'Registry',
    component: Registry
  },
  {
    path: '/main',
    name: 'Main',
    component: Main,
    children: [
      {
        path: 'dashboard',
        component: DashBoard
      },
      {
        path: 'user/query',// 这里不能添加/，否则不起作用
        name: 'UserQuery',
        component: UserQuery
      },
      {
        path: 'user/create',
        name: 'UserCreate',
        component: UserCreate
      },
      {
        path: 'user/edit/:id',
        name: 'UserEdit',
        component: UserEdit
      }
    ]
  } 
];

const router = new Router({
  routes: routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.length === 0) {
    from.name ? next({ name:from.name }) : next('/main/dashboard');
  } else {
    next();
  }
});

export default router;
