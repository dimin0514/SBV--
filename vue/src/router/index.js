import Vue from 'vue'
import Router from 'vue-router'
import Join from '@/components/member/Join.vue'
import Login from '@/components/member/Login.vue'
import MyPage from '@/components/member/MyPage.vue'
import MypageUpdate from '@/components/member/MypageUpdate.vue'

Vue.use(Router)

export default new Router({
	mode:'history',
	routes: [
		{path: '/join', name: 'join', component: Join},
		{path: '/login', name: 'login', component: Login},
		{path: '/mypage', name: 'mypage', component: MyPage},
		{path: '/mypageupdate', name: 'mypageupdate', component: MypageUpdate}
	]
})