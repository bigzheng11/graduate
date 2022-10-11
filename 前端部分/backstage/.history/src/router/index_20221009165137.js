import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login";
import Index from "../views/Index";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Login",
        component: Login,
    },
    {
        path: "/",
        name: "Index",
        component: Index,
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
