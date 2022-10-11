import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login";
import Index from "../views/Index";
import UserList from "../views/user/UserList";
import UserList from "../views/user/UserList";

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
        ],
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
