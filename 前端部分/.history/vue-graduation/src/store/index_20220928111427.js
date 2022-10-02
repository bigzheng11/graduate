import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //true为启用夜间模式
    isNight: false,
    goodsAllList

  },
  getters: {
  },
  mutations: {
    RecommendGoodListMutations(state, param) {
      state.isNight=param
    }
  },
  actions: {
    RecommendGoodListActions(state, param) {
          state.commit("RecommendGoodListMutations", param);
      },
  },
  modules: {
  }
})
