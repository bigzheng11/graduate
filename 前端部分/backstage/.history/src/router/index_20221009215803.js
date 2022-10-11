import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login";
import Index from "../views/Index";
import UserList from '../components/user/UserList';

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
        children
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
