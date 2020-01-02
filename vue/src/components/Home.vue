<template>
	<div id="app">
		<layout>
			<template #header="header">
				<h1>{{header.title}}</h1>
				<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			</template>
			<template #sidebar="sidebar">
				<ul v-if="loginCheck" class="menu" >
					<li v-for="sidebar of sidebarCheck" :key="sidebar.menu">
						<router-link :to='sidebar.link'>{{sidebar.menu}}</router-link>
					</li>
				</ul>
<!-- 				<div v-switch="sidebarCheck">
					<div v-case="'preSidebar'">
						<component :is="'pre-sidebar'"></component>
					</div>
					<div v-case="'managerSidebar'">
						<component :is="'manager-sidebar'"></component>
					</div>
					<div v-case="'studentSidebar'">
						<component :is="'student-sidebar'"></component>
					</div>
				</div> -->
			</template>
			<!--<template #sidebar="sidebar"> </template> -->
			<template #content="content"><router-view/></template>
			<template #footer="footer">{{footer.title}}</template>
		</layout>
	</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import PostAuth from "@/components/cmm/PostAuth.vue"
import PreAuth from "@/components/cmm/PreAuth.vue"
import ManagerSidebar from "@/components/cmm/ManagerSidebar.vue"
import PreSidebar from "@/components/cmm/PreSidebar.vue"
import StudentSidebar from "@/components/cmm/StudentSidebar.vue"
// import { store } from "@/store"
export default {
	components:{
		Layout, PreAuth, PostAuth, ManagerSidebar, PreSidebar, StudentSidebar
	},
	data(){
		return{
			
		}
	},
	computed:{
		loginCheck: function(){
			return this.$store.state.admin.isAuth
			// return this.$store.state.common.authCheck
		},
		sidebarCheck: function(){
			return this.$store.state.admin.sidebars
			// return this.$store.state.common.sidebars
		}
		
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>