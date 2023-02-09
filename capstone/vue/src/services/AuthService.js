import axios from 'axios';

export default {
  // Users
  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
  // Band
  createBand(band) {
    return axios.post('/band', band)
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
    let postObject = {
      genreIds: ids
    };
    return axios.post('/band/genre', postObject)
  },

  // Notifications
  addNotifs(notification){
    return axios.post('/notifications',notification)
  },
  getNotificationsByUser(userId) {
    return axios.get(`/notifications/${userId}`)
  },

  getNotificationsByUserOld(userId) {
    return axios.get(`/notifications/sort-old/${userId}`)
  },
  getNotificationsByUserAZ(userId) {
    return axios.get(`/notifications/sort-band-name-az/${userId}`)
  },
  getNotificationsByUserZA(userId) {
    return axios.get(`/notifications/sort-band-name-za/${userId}`)
  },
  
  // Following
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

  // Genres
  addGenreBand(genreBand) {
    return axios.post('/genre-band', genreBand)
  },

  addOneGenre(genre) {
    return axios.post('/genres/add', genre)
  },

  deleteGenre(genre) {
    return axios.delete('/genres/delete',  {
      data: genre
    })
  },

  getGenres() {
    return axios.get('/genres')
  },

  getGenresByBandId(bandId) {
    return axios.get(`/genres/bands/${bandId}`)
  },

  getGenreByGenreId(genreId) {
    return axios.get(`/genres/${genreId}`)
  },

  //Photos 
  getPhotos(bandId) {
    return axios.get(`/photo/band/${bandId}`)
  },

  addPhoto(photo) {
    return axios.post('/photo/add', photo)
  },
  updatePhotos(photos) {
    return axios.put('/photo/update', photos)
  }
}
