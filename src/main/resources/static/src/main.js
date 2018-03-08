// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import VueResource from "vue-resource";
import axios from 'axios'
import iVueui from 'ivueui';
import 'ivueui/dist/styles/icon.css';
import 'ivueui/dist/styles/ivueui.css';
import { Message } from 'element-ui';

Vue.use(ElementUI);
Vue.use(VueResource);
Vue.use(iVueui);

Vue.prototype.$axios = axios;
axios.defaults.baseURL = process.env.API_HOST;
axios.defaults.withCredentials = true;
// 超时时间
axios.defaults.timeout = 5000;
// http请求拦截器
axios.interceptors.request.use(config => {
  return config;
}, error => {
  Message.error({ message: '加载超时！' });
  return Promise.reject(error);
});
// http响应拦截器
axios.interceptors.response.use(data => {
  return data;
}, error => {
  if (error.response.status == 401) {
    Message.error({ message: '未登录，3秒后跳转至登录页面！' });
    setTimeout(() => {
      router.push({ path: "/login" });
    }, 3000);
  } else if (error.response.status == 402) {
    Message.error({ message: '没有权限访问！' });
  }
  return Promise.reject(error);
});

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  beforeCreate: () => {
    console.group('beforeCreate 创建前状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el); //undefined
    console.log("%c%s", "color:red", "data   : " + this.$data); //undefined
    console.log("%c%s", "color:red", "message: " + this.message)
  },
  created: () => {
    console.group('created 创建完毕状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el); //undefined
    console.log("%c%s", "color:red", "data   : " + this.$data); //已被初始化
    console.log("%c%s", "color:red", "message: " + this.message); //已被初始化
  },
  beforeMount: () => {
    console.group('beforeMount 挂载前状态===============》');
    console.log("%c%s", "color:red", "el     : " + (this.$el)); //已被初始化
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data); //已被初始化
    console.log("%c%s", "color:red", "message: " + this.message); //已被初始化
  },
  mounted: () => {
    console.group('mounted 挂载结束状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el); //已被初始化
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data); //已被初始化
    console.log("%c%s", "color:red", "message: " + this.message); //已被初始化
  },
  beforeUpdate: () => {
    console.group('beforeUpdate 更新前状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el);
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data);
    console.log("%c%s", "color:red", "message: " + this.message);
  },
  updated: () => {
    console.group('updated 更新完成状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el);
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data);
    console.log("%c%s", "color:red", "message: " + this.message);
  },
  beforeDestroy: () => {
    console.group('beforeDestroy 销毁前状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el);
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data);
    console.log("%c%s", "color:red", "message: " + this.message);
  },
  destroyed: () => {
    console.group('destroyed 销毁完成状态===============》');
    console.log("%c%s", "color:red", "el     : " + this.$el);
    console.log(this.$el);
    console.log("%c%s", "color:red", "data   : " + this.$data);
    console.log("%c%s", "color:red", "message: " + this.message)
  }
});
