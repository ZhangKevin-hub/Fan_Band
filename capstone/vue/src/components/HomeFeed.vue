<template>
  <div>
      
     <notification-card v-for="notification in notifications" v-bind:key="notification"></notification-card>
      
  </div>
</template>

<script>
import NotificationCard from '../components/NotificationCard.vue';
export default {
    name: 'homeFeed',
    components: {NotificationCard},
    data(){
        return {
            notifications: [1, 2, 3, 4, 5] // get from database/store
        }
    }
}
</script>

<style>

</style>