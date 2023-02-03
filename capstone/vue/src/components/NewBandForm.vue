<template>
  <div>
    <form id="newBandForm">
      <div class="form-element">
        <label for="bandName">Band Name: </label>
        <input type="text" id="bandName" v-model="band.bandName" />
      </div>
      <div class="form-element">
        <label for="description">Description: </label>
        <input type="text" id="description"  v-model="band.description"/>
      </div>
      <div class="form-element">
        <label for="coverImage">Cover Image Link: </label>
        <input type="text" id="coverImage" v-model="band.image" />
      </div>
      <div class="form-element">
        <label for="genres">Genres: </label>
        <p v-for="(genre, index) in genres" v-bind:key="index"> {{ index }}: {{ genre.name }}
        </p>
        <ul>
            <li v-for="(genre, index) in possibleGenres" v-bind:key="index">
                <input type="checkbox" :id="index" :value="genre" v-on:change="editSelectedGenres(genre)">
                <label :for="index">{{ genre.name }}</label>
            </li>
        </ul>
      </div>
      <button type="submit" v-on:click.prevent="submitForm()">Create Band</button>
    </form>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
import authService from '../services/AuthService';
export default {
  data() {
    return {
      possibleGenres: this.$store.state.genreOptions,
      band: {
          bandName: "", 
          description: "",
          image: "",
          userId: -1,
          genreIds: []
      },
      genres: []
    };
  },
  props: {
    editing: Boolean
  },
  methods: {
      editSelectedGenres(genre){
          const filteredList = this.genres.filter( (eachGenre)=> {
              return eachGenre === genre;
          })
          if (filteredList.length === 0){
              this.genres.push(genre);
              this.band.genreIds.push(genre.id);
          } else {
              this.genres = this.genres.filter( (eachGenre) => {
                  return eachGenre !== genre;
              } );
              this.band.genreIds = this.band.genreIds.filter( (eachId) => {
                return eachId !== genre.id
              })
          }
      },
      submitForm(){
          this.band.userId = this.$store.state.user.id;
          console.log(this.band.userId)
          authService.createBand(this.band, this.genreIds)
            .then( response => {
                if (response.status == 200){
                    this.resetForm();
                    this.assignGenres();
                }
            })
          .catch((error)=> {
              console.log("failed to create band");
              console.log(error.response);
          });
          
      },
      resetFrom(){
        this.band = {
          bandName: "", 
          description: "",
          image: "",
          userId: -1
      }
      },
      assignGenres(){
        AuthService.addGenres(this.genres).then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
      }
  }
};
</script>

<style>
#newBandForm {
    text-align: center;
}
ul {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

li {
    list-style: none;
}
</style>