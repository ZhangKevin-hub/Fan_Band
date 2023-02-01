<template>
  <div>
    
     <notification-card v-for="(notification, index) in notifications" v-bind:key="index"
     v-bind:notification="notification"></notification-card>
      
  </div>
</template>

<script>
import NotificationCard from '../components/NotificationCard.vue';
//import AuthService from '../services/AuthService';
export default {
    name: 'homeFeed',
    components: {NotificationCard},
    data(){
        return {
            notifications: []
            //this.$store.state.notifications
            // get from database/store
        }
    },
    created(){
        const notificationsToSet = [{
                    bandName: "Nirvana",
                    messageDate: '1/24/23',
                    message: 'Blah blah marbles',
                    bandId: 1
                }];
        //AuthService.getNotificationsByBand(this.$state.store.band.bandId);
        this.$store.state.notifications = notificationsToSet;
        this.notifications = this.$store.state.notifications;
    }
}
</script>

<style>

</style>