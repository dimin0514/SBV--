<template>
<div id="post-auth">
     <input type="button" value="로그아웃" @click.prevent="logout"/>
     <input type="button" value="회원탈퇴 " @click.prevent="withdrawal"/>
</div>	
</template>
<script>
import axios from "axios"
import {store} from "../../store"
export default{
     methods : {
        logout(){
         alert(`로그아웃 `)
          store.state.person = {},
          store.state.authCheck = false,
          store.state.sidebar = 'preSidebar',
          this.$router.push({path: '/login'})
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
    }      
    }
}
</script>
<style scoped>
</style>