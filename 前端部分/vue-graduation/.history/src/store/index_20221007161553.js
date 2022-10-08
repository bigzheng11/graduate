import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        //true为启用夜间模式
        isNight: false,
        recommendGoodList: [],
        nowGoodItemMutations: {},
    },
    getters: {},
    mutations: {
        RecommendGoodListMutations(state, param) {
            state.recommendGoodList = param;
        },

        nowGoodItemMutations(state, param) {
            state.nowGoodItemMutations = param;
        },
    },
    actions: {
        RecommendGoodListActions(state, param) {
            state.commit("RecommendGoodListMutations", param);
        },

        nowGoodItemActions(state, param) {
            state.commit("nowGoodItemMutations", param);
        },
    },
    modules: {},
});
