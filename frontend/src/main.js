// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueApexCharts from 'vue-apexcharts'

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api/'
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI, 'en')
Vue.use(VueApexCharts)
Vue.component('apexchart', VueApexCharts)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>'
})
