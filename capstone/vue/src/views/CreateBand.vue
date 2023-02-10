<template>
  <div id="NewBand">
      <h1 class="heading">New Band Form</h1>
      <new-band-form v-bind:editing="false"></new-band-form>
  </div>
</template>

<script>
import NewBandForm from '../components/NewBandForm.vue';
export default {
    components: {
        NewBandForm
    }
}
</script>

<style>
h1 {
    text-align: center;
}

#NewBand {
     background-image: url('../assets/images/callie-morgan.jpg');

  background-size: 100%;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  min-height: 100%;
  width: 100vw;
}



</style>