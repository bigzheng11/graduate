import Vue from "vue";
import VueRouter from "vue-router";
import Index from "../views/Index.vue";
import Shopping from "../views/Shopping.vue";
import UserCenter from "../views/UserCenter.vue";
import Video from "../views/Index/Video.vue";
import Recommend from "../views/Index/Recommend.vue";
import GoodsDetail from "../views/GoodsDetail.vue";
import BuyPage from "../views/BuyPage.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Register from "../views/Register.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index,
        // 使用路由重定向,首页默认显示视频
        redirect: "/video",
        children: [
            {
                path: "/video",
                name: "Video",
                component: Video,
            },
            {
                path: "/recommend",
                name: "Recommend",
                component: Recommend,
            },
        ],
    },
    {
        path: "/goodsdetail",
        name: "GoodsDetail",
        component: GoodsDetail,
    },

    {
        path: "/login",
        name: "Login",
        component: Login,
    },
    {
        path: "/register",
        name: "Register",
        component: Register,
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
    {
        path: "/buypage",
        name: "BuyPage",
        component: BuyPage,
    },
];

const router = new VueRouter({
    mode: "history",
    routes,
});

export default router;
