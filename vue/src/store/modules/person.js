// import loginAPI from '@/api/loginAPI'
import axios from "axios"
import Constant from "@/store/modules/mutation_types"

const state = {
	person : {}
}
const getters ={
	getPerson: state => state.person
}
const actions = {
	async login(){
		alert(`${this.userid} ,  ${this.passwd}`)
		let url = `${this.$store.states.context}/login`
		let data = {
			userid: this.userid,
			passwd: this.passwd
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
					this.$store.state.commit(Constant.person,res.data.person) 
					this.$store.commit(Constant.IS_AUTH, true)
	
					alert(`스토어에 저장성공 ${this.$store.state.authCheck}`)
					if(this.$store.state.person.role !== 'student'){
						this.$store.commit(Constant.sidebar,'managerSidebar') 
						this.$store.commit(Constant.headerMessage,'관리자 화면')
						this.$router.push({path: '/studentList'})
					}else{
						this.$store.commit(Constant.sidebar,'studentSidebar') 
						this.$store.commit(Constant.headerMessage,'학생 화면')
						this.$router.push({path: '/myPage'})
					}
				}else{
					alert(`로그인실패`)
					this.$router.push({path: '/login'})
				}
			})
			.catch(()=>{
			alert('AXIOS 실패')
			}
		)
	},
	async join(){
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
                    // this.person = res.data.person
                    this.$store.state.commit(Constant.person,res.data.person) 
                    this.$router.push({path:`/mypage`})
                }else{
                     alert(`회원가입실패 `)
                }
				this.person = res.data.person
                 
            })
            .catch(()=>{
                alert('AXIOS 실패')
			}
		)
	}  
}
const mutations = {
	LOGIN (state, person) {
    state.person = person
	},
	LOGOUT (state) {
    state.person = null
	}
}


export default{
	state,
	getters,
	actions,
	mutations
}