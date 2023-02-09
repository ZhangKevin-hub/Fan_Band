<template>
  <div>
    <h2 class="heading">Edit Genres</h2>
    <ul>
      <li>Current Genre:</li>
      <li v-for="(genre, index) in genres" :key="index">
        {{ genre.name }}
        <button id = "deleteGenreButton" @click="deleteGenre(index)">Delete</button>
      </li>
    </ul>
    <form id="genre-bar">
      <label for="name">Genre Name:</label>
      <input v-model="newGenreName" type="text" id="name" name="name">
      <button id = "addNewGenreButton" @click.prevent="addGenre">Add Genre</button>
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
.heading{
  text-align: center;
}
#genre-bar{
  text-align: center;
}
#deleteGenreButton{
  --color: hsl(0, 100%, 64%);
  --hover: hsl(0, 100%, 64%);
  color: var(--color);
  transition: 0.25s;
  border: 2px solid var(--color);
}
#deleteGenreButton:focus {
  box-shadow: 
    inset -3.5em 0 0 0 var(--hover),
    inset 3.5em 0 0 0 var(--hover);  
  color: white;
}

#addNewGenreButton{
  --color: hsl(111, 100%, 74%);
  --hover: hsl(111, 100%, 74%);
  color: var(--color);
  transition: 0.25s;
  border: 2px solid var(--color);
}
#addNewGenreButton :focus {
  box-shadow: 
    inset -3.5em 0 0 0 var(--hover),
    inset 3.5em 0 0 0 var(--hover);  
  color: white;
}
button{
  background-color: rgb(204, 123, 197);
}


</style>
