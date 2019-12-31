import axios from 'axios'

const getUserInfo = (userid, passwd) => {
  return axios.get('/endpoint-for-get-user-info', {
    params: {
      'userid': userid,
      'passwd': passwd
    }
  })
}

const isFinished = userid => {
  return axios.get('/endpoint-for-is-finished', {
    params: {
      'userid': userid
    }
  })
}

export default {
  async login (userid, passwd) {
    try {
      const getUserInfoPromise = await getUserInfo(userid, passwd)
      const isFinishedPromise = await isFinished(userid) // Promise.all의 예시를 위해 집어넣음
      const [userInfoResponse, isFinishedResponse] = await Promise.all([getUserInfoPromise, isFinishedPromise])
      if (userInfoResponse.data.length === 0) return 'noAuth' // 로그인 결과에 따른 분기 처리를 해준다
      if (isFinishedResponse.data[0].CNT > 0) return 'done'
      return userInfoResponse
    } catch (err) {
    alert(`에러 `+err)
    }
  }
}