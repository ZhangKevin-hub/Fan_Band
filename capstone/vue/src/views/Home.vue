<template>
  <div class="home">
    <h1 class="heading" >Home</h1>
    <router-link v-bind:to="{ name: 'createBand'}">Create New Band</router-link>
    <home-feed></home-feed>
  </div>
</template>

<script>
import HomeFeed from '../components/HomeFeed.vue';
export default {
  name: "home",
  components: { HomeFeed}
};
</script>
<style scoped>
.home {
  background-image: url(../assets/images/90sbackground3.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  height: 100vh;
  width: 100vw;
}


</style>
