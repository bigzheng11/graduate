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
import VideoPlayer from "vue-video-player/src";
import "vue-video-player/src/custom-theme.css";
import "video.js/dist/video-js.css";

app.use(VideoPlayer)


new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
