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

Vue.use(ElementUI);
Vue.use(VueResource);
Vue.use(iVueui);

Vue.prototype.$axios = axios;

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
