<template>
	<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>This is a simpleRegister Form made using Boostrap.</p>
                </div>

                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" v-model="userid" class="form-control" placeholder="Your id *" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="name" class="form-control" placeholder="your Name *" value=""/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" v-model="passwd" class="form-control" placeholder="Your Password *" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="birthday" class="form-control" placeholder="Your birthdate *" value=""/>
                            </div>
                        </div>
                    </div>
                    <button @click.prevent="join" type="button" class="btnSubmit">Submit</button>
                </div>
            </div>
        </div>
</template>
<script>
import axios from 'axios'
export default {
	data () {
		return {
			context : 'http://localhost:8080/',
			userid :'',
			passwd: '',
			name:'',
            birthday:'',
            person:{}
		}
	},
	methods:{
		join(){
            alert(`thiscontext는? `)
			let url =`${this.context}/join`
            let data = {
                userid : this.userid,
				passwd : this.passwd,
				birthday : this.birthday,
				name: this.name
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
                    alert(`회원가입 성공`)
                    this.person = res.data.person
                    
                    this.$router.push({path:`/mypage`})
                }else{
                     alert(`회원가입실패 `)
                }
				this.person = res.data.person
                 
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })

		}
	}
}
</script>
<style scoped>
.note
{
    text-align: center;
    height: 80px;
    background: -webkit-linear-gradient(left, #0072ff, #8811c5);
    color: #fff;
    font-weight: bold;
    line-height: 80px;
    width:50%
}
.form-content
{
    padding: 5%;
    border: 1px solid #ced4da;
    margin-bottom: 2%;
    width:50%
}
.form-control{
    border-radius:1.5rem;
}
.btnSubmit
{
    border:none;
    border-radius:1.5rem;
    padding: 1%;
    width: 20%;
    cursor: pointer;
    background: #0062cc;
    color: #fff;
}
</style>