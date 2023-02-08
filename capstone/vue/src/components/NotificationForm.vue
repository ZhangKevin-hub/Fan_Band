<template>
    <div>
      <input type="text" v-model="message"/>
      <button v-on:click="addNotification">Send Notification</button>
    </div>
  </template>
  
  <script>
  import AuthService from '../services/AuthService.js';
  export default {
    data() {
      return {
        message: ''
      }
    },
    methods: {
      addNotification() {
        const notification = {
          bandId: this.$store.state.band.bandId,
          message: this.message, 
        }
        AuthService.addNotifs(notification).then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
        this.message = ''
      }
    }
  }
  </script>