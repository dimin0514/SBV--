<template>
<div class="login-form">
    <form>
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" v-model="userid" class="form-control" placeholder="Username" required="required" >
        </div>
        <div class="form-group">
            <input type="password" v-model="passwd" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="login" type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>        
    </form>
    <p class="text-center"><router-link to='/join'>Create an Account</router-link></p>
</div>
</template>
<script>
import axios from 'axios'
import {store} from "../../store"
export default {
	data () {
		return {
            context : 'http://localhost:8080/',
            result : '',
            alert: '로그인',
            userid :'',
            passwd: '',
            person:{}
		}
    },
    methods:{
        login(){
            alert(`id는 ${this.userid} 비밀번호는 ${this.passwd}`)
            let url =`${this.context}/login`
            let data = {
                userid : this.userid,
                passwd : this.passwd
            }
            let headers = {
              'authorization': 'JWT fefege..',
              'Accept' : 'application/json',
              'Content-Type': 'application/json'
            }
            axios
            .post(url, data, headers)
            .then(res=>{
                
                if(res.data.result === "SUCCESS"){
                    alert(`로그인 성공 ${this.userid}`)
                    store.state.person = res.data.person
                    store.state.authCheck = true
                    // store.state.loginedUid = this.person.userid
                    // store.state.loginedPwd = this.person.passwd
                    // store.state.name = this.person.name
                    // store.state.birthday = this.person.birthday
                    // store.state.id = this.person.id
                    // store.state.score = this.person.score
                    // store.state.passwd =this.person.passwd
                    alert(`스토어에 저장성공 ${store.state.authCheck}`)
                    this.$router.push({path:'/mypage'})
                }else{
                    alert(`로그인 실패`)
                    this.$router.push({path:'/'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
        }
    }
}
</script>
<style scoped>
.login-form {
	width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
     min-height: 38px;
     border-radius: 2px;
}
.btn {        
     font-size: 15px;
     font-weight: bold;
}
</style>