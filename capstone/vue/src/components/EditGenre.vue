<template>
  <div>
    <h2>Edit Genres</h2>
    <form>
      <label for="name">Genre Name:</label>
      <input v-model="newGenreName" type="text" id="name" name="name">
      <button @click.prevent="addGenre">Add Genre</button>
    </form>
    <ul>
      <li v-for="(genre, index) in genres" :key="index">
        {{ genre }}
        <button @click.prevent="deleteGenre(index)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "EditGenre",
  data() {
    return {
      genres: [],
      newGenreName: ""
    };
  },
  methods: {
    addGenre() {
      this.genres.push(this.newGenreName);
      this.newGenreName = "";
    },
    deleteGenre(index) {
      this.genres.splice(index, 1);
    }
  }
};
</script>

<style>

</style>
