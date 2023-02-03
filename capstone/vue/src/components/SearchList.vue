<template>
  <div>
    <label for="searchBar">Enter Band Name to Search For: </label>
    <input type="text" id="searchBar" v-model="searchInput" />
    <ul>
      <li v-for="(genre, index) in possibleGenres" v-bind:key="index">
        <input
          type="checkbox"
          :id="index"
          :value="genre"
          v-on:change="editSelectedGenres(genre)"
        />
        <label :for="index">{{ genre.name }}</label>
      </li>
      <button v-on:click="applyGenreFilter">Add Genre Filter</button>
    </ul>
    <div v-for="band in filteredBands" :key="band.bandId">
      <h4 v-on:click="loadBand(band)">{{ band.bandName }}</h4>
      <p>{{ band.description }}</p>
    </div>
  </div>
</template>
<script>
import AuthService from "../services/AuthService";
export default {
  name: "searchList",
  computed: {
    filteredBands() {
      return this.bands.filter((band) => {
        return band.bandName
          .toLowerCase()
          .includes(this.searchInput.toLowerCase());
      });
    },
  },
  data() {
    return {
      searchInput: "",
      bands: [],
      possibleGenres: this.$store.state.genreOptions,
      genres: [],
    };
  },
  methods: {
    loadBand(band) {
      this.$store.commit("SET_CURRENT_BAND", band);
      this.$router.push({ name: "bandPage" });
      console.log("clicked");
    },
    editSelectedGenres(genre) {
      const filteredList = this.genres.filter((eachGenre) => {
        return eachGenre === genre;
      });
      if (filteredList.length === 0) {
        this.genres.push(genre.id);
      } else {
        this.genres = this.genres.filter((eachGenre) => {
          return eachGenre !== genre;
        });
      }
    },
    applyGenreFilter() {
      if (this.genres.length === 0){
        AuthService.getAllBands()
      .then((response) => {
        this.bands = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
      } else {
        AuthService.getBandsByGenre(this.genres).then(response => {
          this.bands = response.data;
        })
        .catch((error) => {
        console.log(error);
      });
      }
    }
  },
  created() {
    AuthService.getAllBands()
      .then((response) => {
        this.bands = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>
<style scoped>
</style>
  
