import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  createBand(band) {
    return axios.post('/band', band)
  },

  getBand(bandId) {
    return axios.get(`/band/${bandId}`)
  },

  getNotificationsByUser() {
    return axios.get(``)
  }

}
