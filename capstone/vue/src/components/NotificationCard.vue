<template>
<div>
  <div v-if="true"> <!--v-if notification has content -->
    <h3 v-on:click="setCurrentBand(notification.bandId)">{{ notification.bandName }}</h3>
    
      <p>{{ notification.messageDate }}</p>
      <p>{{ notification.message }}</p>
  </div>
  <div v-else>
      <h1>Sorry No Notifications</h1>
  </div>
</div>
</template>

<script>
//import AuthService from '../services/AuthService'
export default {
    name: 'notificationCard',
    props: {
        notification: Object
        },
    methods: {
        setCurrentBand(id) {
            const band = {
                bandId: id, 
                bandName: 'Nirvana',
                description: 'Band from back in the day',
                image: '',


            }
           this.$store.commit('SET_CURRENT_BAND', band); // AuthService.getBand(id)
           this.$router.push({name: 'bandPage'})
        }
    }
}
</script>

<style>
#card-div {
    width: 60%;
    margin: 20px;
    border: 5px solid;
    margin-right: auto;
    margin-left: auto;
}

</style>