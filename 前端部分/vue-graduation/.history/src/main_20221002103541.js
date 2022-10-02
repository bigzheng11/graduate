import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

//element-ui安装
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
Vue.use(ElementUI);

//axios
import axios from "axios";
Vue.prototype.$axios = axios;

//挂载轮播图
import VueAwesomeSwiper from "vue-awesome-swiper";
import "swiper/dist/css/swiper.css";
Vue.use(VueAwesomeSwiper);

//引入视频播放
import VideoPlayer from "vue-video-player";
import "vue-video-player/src/custom-theme.css";
import "video.js/dist/video-js.css";
Vue.use(VideoPlayer);

//引入百度地图API
import BaiduMap from "vue-baidu-map";
Vue.use(BaiduMap, {
    ak: "M5vGUgenF5VEYzsE1ftVdfSt7X3694zu",
});

//引入vant组件
import Vant from "vant";
import "vant/lib/index.css";
Vue.use(Vant);

//引入qs
//在main.js引入qs
import qs from "qs";
Vue.prototype.$qs = qs;

//挂载其他
// Vue.prototype.$showLoading = showLoading;
// Vue.prototype.$hideLoading = hideLoading;
// Vue.prototype.$getCurDate = getCurDate;
// Vue.prototype.$setSessionStorage = setSessionStorage;
// Vue.prototype.$getSessionStorage = getSessionStorage;
// Vue.prototype.$removeSessionStorage = removeSessionStorage;
// Vue.prototype.$setLocalStorage = setLocalStorage;
// Vue.prototype.$getLocalStorage = getLocalStorage;
// Vue.prototype.$removeLocalStorage = removeLocalStorage;

// 引入swiper
import Swiper from "swiper";
var mySwiper = new Swiper(".swiper", {
    direction: "vertical", // 垂直切换选项
    loop: true, // 循环模式选项

    // 如果需要分页器
    pagination: {
        el: ".swiper-pagination",
    },

    // 如果需要前进后退按钮
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },

    // 如果需要滚动条
    scrollbar: {
        el: ".swiper-scrollbar",
    },
});

// 路由守卫
router.beforeEach(function (to, from, next) {
    let userinfo = window.sessionStorage.getItem("userinfo");
    if (!(to.path == "/login")) {
        if (userinfo == null) {
            router.push("/login");
        }
    }
    next(); //放行
});

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
