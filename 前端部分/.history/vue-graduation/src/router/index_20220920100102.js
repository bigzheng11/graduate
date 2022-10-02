import Vue from "vue";
import VueRouter from "vue-router";
import Index from "../views/Index.vue";
import Shopping from "../views/Shopping.vue";
import UserCenter from "../views/UserCenter.vue";
import UserCenter from "../views/Index/Video.vue";
import UserCenter from "../views/Index/Recommend.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index,
        children: [
            {
                path: "/Video",
                name: "Video",
                component: Video,
            },
            {
                path: "/shopping",
                name: "Shopping",
                component: Shopping,
            },
        ],
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
    mode: "history",
    routes,
});

export default router;
