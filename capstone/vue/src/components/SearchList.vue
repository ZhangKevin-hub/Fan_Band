<template>
  <div id="searchlist">
    <div>
      <div id="search-bar-div">
        <label for="searchBar" id="searchMessage">Enter Band Name to Search For:&nbsp;</label>
      <input type="text" id="searchBar" v-model="searchInput" />
      <ul>
        <li v-for="(genre, index) in possibleGenres" v-bind:key="index">
          <input
            class="checkbox-genre"
            type="checkbox"
            :value="genre"
            v-on:change="editSelectedGenres(genre)"
          />
          <label :for="index">{{ genre.name }}</label>
        </li>
        <button id="genreFilter" v-on:click="applyGenreFilter()">
          Add Genre Filter
        </button>
      </ul>
      </div>
      
      <div v-if="this.filteredBands.length !== 0">
        <div v-for="band in filteredBands" v-bind:key="band.bandId" class="band-div">
          <h4 v-on:click="loadBand(band)" class="band-name">{{ band.bandName }}</h4>
          <p>{{ band.description }}</p>
        </div>
      </div>
      <div v-else id="noBands">
        <h3>No Bands</h3>
      </div>
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
        return eachGenre === genre.id;
      });
      //filter possible genres to get Ids
      if (filteredList.length === 0) {
        this.genres.push(genre.id);
      } else {
        this.genres = this.genres.filter((eachGenre) => {
          return eachGenre !== genre.id;
        });
      }
      console.log(this.genres);
    },
    applyGenreFilter() {
      console.log("ANDY DEBUG");
      console.log(this.genres.length);
      if (this.genres.length === 0) {
        AuthService.getAllBands()
          .then((response) => {
            this.bands = response.data;
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        console.log("genres");
        console.log(this.genres);
        AuthService.getBandsByGenre(this.genres)
          .then((response) => {
            this.bands = response.data;
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
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
#genreFilter{
  font-family: "Sedgwick Ave Display", cursive;
  font-size: 24px;
}
#search-bar-div {
  display: flex;
  flex-direction: row;
  align-items: baseline;
  justify-content: center;
}
#noBands {
  text-align: center;
  color: white;
  font-family: "Itim", cursive;
}
div {
  text-align: center;
  /* background-image: url("../assets/images/livecrowd1.jpg"); */
  height: auto;
}
.band-div{
   margin: 20px;
  border: 5px solid;
  margin-right: auto;
  margin-left: auto;
  margin-top:30px;
  background-color: rgb(176, 79, 196);
  border-radius: 10px;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
  width: 40%;
}
#searchBar {
  height: 20px;
}
#heading {
  height: 10px;
}
#searchlist {
  /* display: flex;
    justify-content: center; */
  background-image: url("../assets/images/livecrowd1.jpg");
  background-size: 100%;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  min-height: 100%;
  width: 100vw;
}
#searchMessage {
  font-family: "Itim", cursive;
}
.checkbox-genre {
  color: blueviolet;
}
.band-name {
  text-decoration: underline;
}
</style>
  
