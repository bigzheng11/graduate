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
import axios from 'axios';


new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
