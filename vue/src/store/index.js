import Vue from 'vue'
import Vuex from 'vuex'
import common from '@/store/modules/common'
import person from '@/store/modules/person'
import article from '@/store/modules/article'
import loginAPI from '@/api//loginAPI'

Vue.use(Vuex)

export const store = new Vuex.Store({
	modules: {
		common,
		person,
		article
	},
	strict: true,
	async login (userid, passwd) {
    try {
      const loginResponse = await loginAPI.login(userid, passwd)
      return loginResponse
    } catch (err) {
      alert('에러'+err)
    }
  }
})