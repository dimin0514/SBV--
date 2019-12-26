import Vue from 'vue'
import Router from 'vue-router'
import Join from '@/components/member/Join.vue'
import Login from '@/components/member/Login.vue'
import MyPage from '@/components/member/MyPage.vue'
import Admin from '@/components/member/Admin.vue'
import StudentList from '@/components/member/StudentList.vue'
import MypageUpdate from '@/components/member/MypageUpdate.vue'
import ArticleAdd from '@/components/board/ArticleAdd'
import ArticleEdit from '@/components/board/ArticleEdit'
import ArticleFindOne from '@/components/board/ArticleFindOne'
import ArticlesFindSome from '@/components/board/ArticlesFindSome'
import ArticleRemoval from '@/components/board/ArticleRemoval'
import Articles from '@/components/board/Articles'
import StudentAdd from '@/components/student/StudentAdd'
import StudentEdit from '@/components/student/StudentEdit'
import StudentFindOne from '@/components/student/StudentFindOne'
import StudentsFindSome from '@/components/student/StudentsFindSome'
import StudentRemoval from '@/components/student/StudentRemoval'
import Students from '@/components/student/Students'

Vue.use(Router)

export default new Router({
	mode:'history',
	routes: [
		{path: '/articleAdd',name: 'articleAdd', component: ArticleAdd},
		{path: '/articleEdit',name: 'articleEdit', component: ArticleEdit},
		{path: '/articleRemoval',name: 'articleRemoval', component: ArticleRemoval},
		{path: '/articleFindOne',name: 'articleFindOne', component: ArticleFindOne},
		{path: '/articles',name: 'articles', component: Articles},
		{path: '/articlesFindSome',name: 'articlesFindSome', component: ArticlesFindSome},
		{path: '/studentAdd',name: 'studentAdd', component: StudentAdd},
		{path: '/studentEdit',name: 'studentEdit', component: StudentEdit},
		{path: '/studentFindOne',name: 'studentFindOne', component: StudentFindOne},
		{path: '/studentRemoval',name: 'studentRemoval', component: StudentRemoval},
		{path: '/students',name: 'students', component: Students},
		{path: '/studentsFindSome',name: 'studentsFindSome', component: StudentsFindSome},
		{path: '/join', name: 'join', component: Join},
		{path: '/login', name: 'login', component: Login},
		{path: '/mypage', name: 'mypage', component: MyPage},
		{path: '/admin', name: 'admin', component: Admin},
		{path: '/studentList', name: 'studentList', component: StudentList},
		{path: '/mypageupdate', name: 'mypageupdate', component: MypageUpdate}
	]
})