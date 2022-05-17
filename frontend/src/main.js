import {createApp} from "vue";
import Vue from 'vue';
import App from "./App.vue";
import router from "./router";
import {Icon} from "@iconify/vue";
import VueApexCharts from "vue3-apexcharts";
import PerfectScrollbar from "vue3-perfect-scrollbar";
import "vue3-perfect-scrollbar/dist/vue3-perfect-scrollbar.css";
// import "flowbite";
import "./assets/tailwind.css";
import "./assets/animate.css";
import "./assets/sass/css/windzo.css";


var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'


const app = createApp(App);

app.use(router, Icon);
app.use(VueApexCharts);
app.use(PerfectScrollbar);
app.mount("#app");

app.provide('axios',axios);

// Vue.prototype.$axios = axios
// Vue.config.productionTip = false
//
// Vue.use(ApexCharts)


router.beforeEach((to, from, next) => {
    document.querySelector(".flex-sidebar").classList.add("hidden");
    next();
});
