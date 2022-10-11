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
Vue.prototype.$axios  = axios;

//引入qs
import qs from "qs";
Vue.prototype.$qs = qs;

//Echarts
import * as echarts from "echarts";
Vue.prototype.$echarts = echarts;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
