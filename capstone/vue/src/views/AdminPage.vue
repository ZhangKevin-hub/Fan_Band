<template>

  <div id = "adminPage">
      <h1 class="heading">Admin Page</h1>
    <EditGenre></EditGenre>
  </div>
</template>

<script>
import EditGenre from "../components/EditGenre.vue";
export default {
  name: "adminPage",
  components: {
    EditGenre
  }
};
</script>

<style>

</style>
