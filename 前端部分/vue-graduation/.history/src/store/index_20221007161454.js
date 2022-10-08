import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //true为启用夜间模式
    isNight: false,
   recommendGoodList:[]

  },
  getters: {
  },
  mutations: {
    RecommendGoodListMutations(state, param) {
      state.recommendGoodList=param
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
