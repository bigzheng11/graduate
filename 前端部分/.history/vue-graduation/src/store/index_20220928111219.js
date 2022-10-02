import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
    changeNightMutations(state, param) {
      state.isNight=param
    }
  },
  actions: {
    changeNightActions(state, param) {
          state.commit("changeNightMutations", param);
      },
  },
  modules: {
  }
})
