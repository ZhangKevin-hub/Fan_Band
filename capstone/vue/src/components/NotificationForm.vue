<template>
    <div>
      <input type="text" v-model="message"/>
      <button v-on:click="addNotification">Send Notification</button>
    </div>
  </template>
  <script>
  import AuthService from 'path/to/AuthService.js'
  export default {
    data() {
      return {
        message: ''
      }
    },
    methods: {
      addNotification() {
        const notification = {
          bandid: this.$store.state.band.bandId,
          message: this.message, 
        }
        AuthService.addNotifs(notification)
        this.message = ''
      }
    }
  }
  </script>