import { createRouter, createWebHistory } from "vue-router";

// Default Pages
import Dashboard from "../views/Dashboard.vue";
// Component Pages
import Valert from "../views/components/alert.vue";
import Vaccrodion from "../views/components/accordion.vue";
import Vbadges from "../views/components/badges.vue";
import Vbreadcumb from "../views/components/breadcumbs.vue";
import Vbutton from "../views/components/button.vue";
import Vcard from "../views/components/card.vue";
import TestPage from "../views/TestPage";
import DependencyMap from "@/views/maps/DependencyMap";
import Log4jMap from "@/views/maps/Log4jMap";
import LombokMap from "@/views/maps/LombokMap";
import MySQLMap from "@/views/maps/MySQLMap";
import SpringMap from "@/views/maps/SpringMap";
var appname = " - CS209A Project Test Page";



const routes = [
  // Routes
  {
    path: "/",
    name: "Dashboard",
    component: Dashboard,
    meta: { title: "Dashboard " + appname },
  },
  {
    path: "/maps/DependencyMap",
    name: "DependencyMap",
    component: DependencyMap,
    meta: { title: "Dependency Map" + appname },
  },
  {
    path: "/maps/SpringMap",
    name: "SpringMap",
    component: SpringMap,
    meta: { title: "Spring Map" + appname },
  },
  {
    path: "/maps/Log4jMap",
    name: "Log4jMap",
    component: Log4jMap,
    meta: { title: "Log4j Map" + appname },
  },
  {
    path: "/maps/LombokMap",
    name: "LombokMap",
    component: LombokMap,
    meta: { title: "Lombok Map" + appname },
  },
  {
    path: "/maps/MySQLMap",
    name: "MySQLMap",
    component: MySQLMap,
    meta: { title: "Dependency Map" + appname },
  },

  // Components based Routes
  {
    path: "/component/alert",
    name: "Valert",
    component: Valert,
    meta: { title: "Alert" + appname },
  },
  {
    path: "/component/accordion",
    name: "Vaccordion",
    component: Vaccrodion,
    meta: { title: "Accordion" + appname },
  },
  {
    path: "/component/badge",
    name: "Vbadge",
    component: Vbadges,
    meta: { title: "Badge" + appname },
  },
  {
    path: "/component/breadcumb",
    name: "Vbreadcumb",
    component: Vbreadcumb,
    meta: { title: "Breadcumb" + appname },
  },
  {
    path: "/component/button",
    name: "Vbutton",
    component: Vbutton,
    meta: { title: "Button" + appname },
  },
  {
    path: "/component/card",
    name: "Vcard",
    component: Vcard,
    meta: { title: "Card" + appname },
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  proxyTable: {
    '/api': {
      target: 'http://localhost:8443',
      changeOrigin: true,
      pathRewrite: {
        '^/api': ''
      }
    }
  },
  linkExactActiveClass: "exact-active",
});

router.beforeEach((to, from, next) => {
  document.title = to.meta.title;
  next();
});

export default router;
