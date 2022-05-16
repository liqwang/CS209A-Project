import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import Sample from '../components/Sample'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Sample',
      component:  Sample
    },
    {
      path: '/helloworld',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
