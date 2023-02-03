<template>
<div>
  <div v-if="Object.keys(this.$store.state.notifications).length !== 0" id="card-div"> <!--v-if notification has content -->
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
import AuthService from '../services/AuthService'
export default {
    name: 'notificationCard',
    props: {
        notification: Object
        },
    methods: {
        setCurrentBand(id) {
            AuthService.getBand(id)
            .then(response => {
                const band = response.data;
                this.$store.commit('SET_CURRENT_BAND', band);
                this.$router.push({name: 'bandPage'})
            });
           
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