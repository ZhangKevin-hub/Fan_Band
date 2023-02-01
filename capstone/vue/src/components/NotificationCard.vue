<template>
  <div v-if="true"> <!--v-if notification has content -->
      <router-link v-bind:to="{ name: 'bandPage', params: {bandId: notification.band_id} }"
      v-on:click="setCurrentBand(notification.bandId)"
      >
          <h3>{{ notification.bandName }}</h3>
      </router-link>
      <p>{{ notification.messageDate }}</p>
      <p>{{ notification.message }}</p>
  </div>
  <div v-else>
      <h1>Sorry No Notifications</h1>
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
           this.$store.state.band = AuthService.getBand(id)
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