<template>
  <div class="home">
    <h1>Home</h1>
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
