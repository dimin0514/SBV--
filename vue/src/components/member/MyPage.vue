<template>
  <div class="back">
     <div align = "center"><h1><input type="text" v-model="person.name"/>님의 Mypage</h1> <input type="button" value="로그아웃" @click="logout"/></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
                <h5>{{person.passwd}}</h5>
                <button style="height: 38%; width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>성적 확인</h3></legend>
                  <h5>{{person.hak}} 학년 </h5>
                  <h5>{{person.ban}} 반 </h5>
                  <h5>{{person.score}} 점 </h5>
                <br/><br/>
           </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
import {store} from "../../store"
import axios from 'axios'

export default{
  data(){
    return {
       context : 'http://localhost:8080/',
       name: store.state.name,
       person : store.state.person,
       sidebars: [
				{menu:"비밀번호 수정",link:"/update"}
      ],
      authCheck : true
		}
		
	},
  methods:{
     goupdate(){
      alert(`회원정보 수정 `)
      this.$router.push({path:`/mypageupdate`})
      let url = `${this.context}/update`
      let data = {
          hak :this.person.hak,
          ban :this.person.ban,
          score:this.person.score
      }
      let headers = {}
      axios
      .post(url, data, headers)
      .then(
        alert(`변경 성공? `)
      )
      .catch(()=>{
        alert(`axios 실패`)
      })
    }
  },
  create(){

  }
}
</script>
 <style scoped>
.back {width: 700px; margin: 0 ;}
.sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
.pull-left {float: left;}
.pull-right {float: right;}
.top {margin-top: 1%;}
.rt {margin-right: 1%;}
.size {width: 49.5%; height: 100%;}
</style>