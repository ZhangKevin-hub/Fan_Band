<template>
  <div>
      <band-info></band-info>
  </div>
</template>

<script>
import BandInfo from '../components/BandInfo.vue'
export default {
    name: 'bandPage',
  components: { BandInfo },

}
</script>

<style scoped>
div{
  background-attachment: fixed;
background-image: url('../assets/images/wall.jpg');
background-size: cover;
min-height: 100%;
}

</style>