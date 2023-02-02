<template>
  <div>
    
     <notification-card v-for="notification in notifications" v-bind:key="notification.notifId"
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
        const userId = this.$store.state.user.id;
        AuthService.getNotificationsByUser(userId).then(response => {
            const notificationsToSet = response.data;
            this.$store.commit('SET_CURRENT_NOTIFICATIONS', notificationsToSet);
            this.notifications = this.$store.state.notifications;
        })
        .catch(error => {
            console.log(error)
        });
        AuthService.getFollowersByUser(this.$store.state.user.id)
        .then(response => {
            this.$store.state.bandsFollowing = response.forEach( element => {
                return element.bandId;
            })
        })
        .catch(error => {
            console.log(error)
        });
        AuthService.getGenres().then(response => {
            const genres = response.data;
            this.$store.commit('SET_GENRE_OPTIONS', genres)
        })
        .catch(error => {
            console.log(error)
        });
    }
}
</script>

<style>

</style>