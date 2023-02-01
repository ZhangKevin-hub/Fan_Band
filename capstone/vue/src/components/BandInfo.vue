<template>
  <div>
      <h1>{{ band.bandName }}</h1>
      <p>{{ band.description }}</p>
      <img src="" alt="cover image">
      <h5>List of genres</h5>
      <img src="" alt="photo gallergy">

  </div>
</template>

<script>

export default {
    name: 'bandInfo',
    data(){
      return {
        band: {}
      }
    },
    created(){
      this.band = this.$store.state.band;
    }
}
</script>

<style>

</style>