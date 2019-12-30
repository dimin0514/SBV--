<template>
<div>학생들 목록
	<table class="table">
		<tr>
			<th>No.</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생일</th>
			<th>성별</th>
			<th>학년</th>
			<th>반</th>
			<th>점수</th>
			<th>역할</th>
		</tr>
		<tr v-for="(j, i) of list" :key="j.id">
		<td>{{i+1}}</td>
		<td>{{j.userid}}</td>
		<td>{{j.passwd}}</td>
		<td>{{j.name}}</td>
		<td>{{j.birthday}}</td>
		<td>{{j.gender}}</td>
		<td>{{j.hak}}</td>
		<td>{{j.ban}}</td>
		<td>{{j.score}}</td>
		<td>{{j.role}}</td>
		</tr>
	</table>
	<div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
		이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} </span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
		다음
      </button>
	</div>  	
</div>	
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return{
			context: 'http://localhost:8080/',
			list:[],
			pageNum: 0,
			pageCount: 5
		}
	},
	created(){
		axios
		.get(`${this.context}/students`)
		.then(res =>{
			this.list = res.data
		})
		.catch(e=>{
			alert('AXIOS FAIL'+e)
		})
	}
}
</script>
<style scoped>
.table{
	border: 1px solid black
}
.table tr{
	border: 1px solid black
}
.table tr th{
	border: 1px solid black
}
.table tr td{
	border: 1px solid black
}
</style>