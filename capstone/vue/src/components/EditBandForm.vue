<template>
  <div>
      <form id="editBandForm">
          <div class="form-element">
              <label for="bandName">Band Name: </label>
              <input type="text" id="bandName" v-model="band.bandName">
          </div>
          <div class="form-element">
              <label for="bandName">Description: </label>
              <input type="text" id="bandName" v-model="band.description">
          </div>
          <div class="form-element">
              <label for="bandName">Cover Image Link: </label>
              <input type="text" id="bandName" v-model="band.image">
          </div>
          <div class="form-element"></div>
          <div class="form-element"></div>
          <div class="form-element"></div>
      </form>
  </div>
</template>

<script>
export default {
    name: 'editBandForm',
    data() {
        return {
            band: this.$store.state.band
        }
    }
}
</script>

<style>

</style>