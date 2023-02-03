<template>
  <div>
      <h1>New Band Form</h1>
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

</style>