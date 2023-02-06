<template>
  <div>
    <h2>Edit Genres</h2>
    <ul>
      <li>Current Genre:</li>
      <li v-for="(genre, index) in genres" :key="index">
        {{ genre.name }}
        <button @click="deleteGenre(index)">Delete</button>
      </li>
    </ul>
    <form>
      <label for="name">Genre Name:</label>
      <input v-model="newGenreName" type="text" id="name" name="name">
      <button @click.prevent="addGenre">Add Genre</button>
    </form>   
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
export default {
  name: "EditGenre",
  data() {
    return {
      genres: this.$store.state.genreOptions,
      newGenreName: ""
    };
  },
  methods: {
    addGenre() {
      const genreObj = {
        name: this.newGenreName
      }
      this.$store.commit('ADD_GENRE_OPTION', genreObj);
      this.newGenreName = "";
      AuthService.addOneGenre(genreObj).then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error)
      })
    },
    deleteGenre(index) {
      
      const genreToDelete = this.genres[index]
      this.$store.commit('REMOVE_GENRE_OPTION', genreToDelete);
      AuthService.deleteGenre(genreToDelete).then(
        this.genres = this.$store.state.genreOptions
      )
      .catch(error => {
        console.log(error)
      })

    }
  }
};
</script>

<style>

</style>
