import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', redirect:'/manager/home'},
    { path: '/manager', component: () =>import('../views/Manager.vue'),
      children:[
        {path: 'home', meta: {name:'主页'}, component: () =>import('../views/Home.vue'),},
        {path: 'admin', meta: {name:'管理员信息'}, component: () =>import('../views/Admin.vue')},
        {path: 'user', meta: {name:'用户(学生)信息'}, component: () =>import('../views/User.vue')},
        {path: 'person', meta: {name:'个人信息'}, component: () =>import('../views/Person.vue'),},
        {path: 'updatePassword', meta: {name:'修改密码'}, component: () =>import('../views/UpdatePassword.vue'),},
      ]
    },
    { path: '/login', component: () =>import('../views/Login.vue')},
    { path: '/register', component: () =>import('../views/Register.vue')},
    { path: '/notfound', component: () =>import('../views/404.vue'),},
    { path: '/:pathMatch(.*)', redirect: '/notFound' }
  ],
})

export default router
