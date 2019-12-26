import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
		person: {},
		authCheck: false,
		sidebar: 'preSidebar',
		headerMessage:'공통 화면 '
  }
})