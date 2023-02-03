<template>
    <div>
      <input type="text" v-model="searchInput" @input="search"/>
      <ul>
<<<<<<< HEAD
        <li v-for="band in filteredBands" :key="band.id">{{ band.name }}</li>
=======
        <li v-for="item in filteredBands" :key="item.id">{{ item.name }}</li>
>>>>>>> 660099f522753e83fa02d67af78005eb60f24376
      </ul>
    </div>
  </template>
<script>
<<<<<<< HEAD

</script>
=======
export default {
  computed: {
    filteredBands() {
      return this.bands.filter(band => {
        return band.name.toLowerCase().includes(this.searchInput.toLowerCase());
      });
    }
  },
  data() {
    return {
      searchInput: ''
    }
  },
  props: ['bands']
};
</script>
  
>>>>>>> 660099f522753e83fa02d67af78005eb60f24376
