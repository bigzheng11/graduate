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
//配全局属性配置，在任意组件内可以使用this.$qs获取qs对象
Vue.prototype.$qs = qs;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
