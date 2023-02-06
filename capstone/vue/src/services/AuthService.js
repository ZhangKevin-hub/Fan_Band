import axios from 'axios';

export default {
  // lo
  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  createBand(band, genres) {
    return axios.post('/band', band, genres)
  },
  
  updateBand(bandId, updatedBand) {
    return axios.put(`/band/${bandId}`, updatedBand)
  },
  
  getBand(bandId) {
    return axios.get(`/band/${bandId}`)
  },

  getAllBands() {
    return axios.get('/band')
  },

  getBandsByGenre(ids) {
    return axios.get('/band/genre', ids)
  },

  getNotificationsByUser(userId) {
    return axios.get(`/notifications/${userId}`)
  },

  followBand(follower) {
    return axios.post('/followers', follower)
  },

  unfollowBand(follower) {
    return axios.delete('/followers',  {
      data: follower
  })
  },

  getFollowersByUser(userId) {
    return axios.get(`/followers/users/${userId}`)
  },

  addGenres(genres) {
    return axios.put('/genre', genres)
  },

  getGenres() {
    return axios.get('/genres')
  },

  getGenresByBandId(bandId) {
    return axios.get(`/genre-band/band/${bandId}`)
  },

  getGenreByGenreId(genreId) {
    return axios.get(`/genres/${genreId}`)
  }

}
