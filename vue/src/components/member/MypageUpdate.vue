<template>
  <div class="back">
     <div align = "center"><h1><input type="text" v-model="person.name"/>님의 Mypage</h1> <input type="button" value="로그아웃" @click="logout"/></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
                <input type="text" name="pwd" size="20" placeholder="기존 비밀번호 입력" v-model="person.pwd"  style="float: none; width: 70%;">
                <button style="height: 38%; width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>개인정보 변경</h3></legend>
                <input type="text" name="pwd" size="20" placeholder="변경할 학년  입력" v-model="person.hak" style="float: none;width: 70%;">
                <input type="text" name="pwd" size="20" placeholder="변경할 반 입력" v-model="person.ban"  style="float: none;width: 70%;">
                <input type="text" name="pwd" size="20" placeholder="변경할 성적 입력" v-model="person.score"   style="float: none;width: 70%;">
                <br/><br/>
                <button style="height: 20%; width: 70%; float: none;" @click.prevent="modify">수정</button>
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
       person : store.state.person
      


    }
  },
  methods:{
    logout(){
      alert(`로그아웃 `)
        store.state.loginedUid =''
        store.state.loginedPwd = ''
        store.state.name = ''
        store.state.birthday = ''
        store.state.id = ''
        this.$router.push({path:`/login`})
    },
    withdrawal(){
      alert(`회원탈퇴 되냐?`)
      let url = `${this.context}/withdrawal/${store.state.loginedUid}`
       
      axios
      .delete(url)
      .then(
        alert(`회원탈퇴 성공`)
      )
      .catch(()=>{
        alert(`회원탈퇴 실패`)
      })
      this.$router.push({path:`/login`})
      
    },
    modify(){
      alert(`회원정보 수정 `)
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