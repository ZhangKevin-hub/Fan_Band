<template>
  <div>
    
     <notification-card v-for="(notification, index) in notifications" v-bind:key="index"
     v-bind:notification="notification"></notification-card>
      
  </div>
</template>

<script>
import NotificationCard from '../components/NotificationCard.vue';
import AuthService from '../services/AuthService';
export default {
    name: 'homeFeed',
    components: {NotificationCard},
    data(){
        return {
            notifications: []
        }
    },
    created(){
        let notificationsToSet = [];
        AuthService.getNotificationsByUser(this.$store.state.user.userId).then(response => {
            notificationsToSet = response.data;
        });
        
        this.$store.state.notifications = notificationsToSet;
        this.notifications = this.$store.state.notifications;
    }
}
</script>

<style>

</style>