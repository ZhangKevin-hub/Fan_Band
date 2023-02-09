<template>
    <div id="card">
      <input type="text" v-model="message"/>
      <button id = "sendNotification" v-on:click="addNotification">Send Notification</button>
    </div>
  </template>
  
  <script>
  import AuthService from '../services/AuthService.js';
  export default {
    emits: ['addMessage'],
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
        });
        this.message = '';
        this.$emit('add-message', false );
      }
    }
  }
  </script>
<style scoped>
  
#sendNotification{
  color:white;
  background-color: hsl(98, 75%, 66%);
}
#sendNotification span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

#sendNotification span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

#sendNotification:hover span {
  padding-right: 25px;
}
#sendNotification span:after {
  opacity: 1;
  right: 0;
}
  </style>