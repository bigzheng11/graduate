import Vue from "vue";
import VueRouter from "vue-router";
import Index from "../views/Index.vue";
import Shopping from "../views/Shopping.vue";
import UserCenter from "../views/UserCenter.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index,
    },
    {
        path: "/shopping",
        name: "Shopping",
        component: Shopping,
    },
    {
        path: "/usercenter",
        name: "UserCenter",
        component: UserCenter,
    },
];

const router = new VueRouter({
  mid
    routes,
});

export default router;
