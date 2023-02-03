<template>
  <div>
    <input type="text" v-model="searchInput" @input="search" />
      <div v-for="band in filteredBands" :key="band.bandId">
        <h4 v-on:click="loadBand(band)">{{ band.bandName }}</h4>
        <p>{{ band.description }}</p>
        </div>

  </div>
</template>
<script>
import AuthService from '../services/AuthService';
export default {
  name: "Search",
  computed: {
    filteredBands() {
      return this.bands.filter((band) => {
        return band.bandName.toLowerCase().includes(this.searchInput.toLowerCase());
      });
    },
  },
  data() {
    return {
      searchInput: "",
      bands: []
    };
  },
  methods: {
    loadBand(band) {
      this.$store.commit('SET_CURRENT_BAND', band);
      this.$router.push({ name: 'bandPage'});
      console.log("clicked");
    }
  },
  created(){
    AuthService.getAllBands().then(response => {
      this.bands = response.data;
    })
    .catch(error => {
      console.log(error)
    })
  }
};
</script>

  
