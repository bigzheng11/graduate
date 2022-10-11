import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login";
import Index from "../views/Index";
import UserList from "../views/user/UserList";
import UserInterest from "../views/user/UserInterest";

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
                name: "用户管理",
                path: "userList",
                component: UserList,
            },
            {
                name: "用户xing管理",
                path: "UserInterest",
                component: UserInterest,
            },
        ],
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
