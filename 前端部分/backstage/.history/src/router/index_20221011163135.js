import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login";
import Index from "../views/Index";
import UserList from "../views/user/UserList";
import UserDetail from "../views/user/UserDetail";
import UserInterest from "../views/user/UserInterest";
import GoodsList from "../views/goods/GoodsList";
import GoodsEcharts.vue from "../views/goods/GoodsEcharts.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Login",
        component: Login,
    },
    {
        path: "/index",
        name: "Index",
        component: Index,
        children: [
            {
                name: "用户Eacharts总览",
                path: "userList",
                component: UserList,
            },
            {
                name: "用户兴趣管理",
                path: "UserInterest",
                component: UserInterest,
            },
            {
                name: "用户detail管理",
                path: "UserDetail",
                component: UserDetail,
            },
            {
                name: "商品List",
                path: "GoodsList",
                component: GoodsList,
            },
            {
                name: "商品详情",
                path: "GoodsEcharts.vue",
                component: GoodsEcharts.vue,
            },
        ],
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
