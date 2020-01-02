//import loginAPI from '@/api/loginAPI'
import Constant from '@/store/modules/mutation_types'
import axios from 'axios'
const state = {
    admin: {},
    sidebars : [
                {menu:"학생목록",link:"/students"},
                {menu:"조건별 학생검색",link:"/studentsFindSome"},
				{menu:"학생성적수정",link:"/update"},
				{menu:"ID 학생검색",link:"/studentFindOne"}
            ],
    isAuth:'',
    header:'로그인전'
}
const getters = {
    getAdmin: state => state.admin,
    getIsAuth : state => state.isAuth,
    getHeader : state => state.header
}
const actions = {
    login({commit},{context, userid, passwd}){
            alert(`${context},${userid},${passwd}` )
            // alert(`${this.userid} ,  ${this.passwd}`)
             let url = `${context}login`
             // let url = `${ this.$store.state.context}/login`
            // let data = {
            //     userid: this.userid,
            //     passwd: this.passwd
            // }
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, {userid, passwd}, headers)
            .then(({data})=>{commit('LOGIN',data)})
            .catch(()=>{
                alert('AXIOS 실패')
            })  
            /* axios
            .post(url, data, headers)
            .then(res=>{
                if(res.data.result === "SUCCESS"){
                  this.$store.commit(Constant.PERSON, res.data.person)
                  this.$store.commit(Constant.IS_AUTH, true)
                  
                  alert(`스토어에 저장성공 ${this.$store.state.authCheck}`)
                  if(this.$store.state.person.role !== 'student'){
                      this.$store.commit(Constant.SIDEBAR, 'managerSidebar')
                      this.$store.commit(Constant.HEADER_MESSAGE, '관리자화면')
                      this.$router.push({path: '/admin'})
                  }else{
                      this.$store.commit(Constant.SIDEBAR, 'studentSidebar')
                      this.$store.commit(Constant.HEADER_MESSAGE, '학생화면')
                      this.$router.push({path: '/myPage'})
                  }
                  
                }else{
                  alert(`로그인실패`)
                  this.$router.push({path: '/login'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            }) */  
            
          },
      async join(){
              let url = `${this.context}/join`
              let data = {
                  userid : this.userid,
                  passwd : this.passwd,
                  name : this.name,
                  birthday : this.birthday
              }
              let headers = {
                      'authorization': 'JWT fefege..',
                      'Accept' : 'application/json',
                      'Content-Type': 'application/json'
              }
              axios
              .post(url, data, headers)
              .then(res=>{
                  if(res.data.result==="SUCCESS"){
                      this.$store.commit(Constant.PERSON, res.data.person)
                      this.$router.push({path : '/mypage'})
                  }else{
            this.$router.push({path : '/join'})
          }
              })
              .catch(()=>{
                  alert(`axios 실패!`)
              })
          }
}
const mutations = {
    LOGIN (state, data) {
        state.isAuth = data.result
        state.admin = data.person
        state.header = '로그인후'

    },
    LOGOUT (state) {
        state.admin = {}
    },
}

export default {
  name: 'admin',
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}