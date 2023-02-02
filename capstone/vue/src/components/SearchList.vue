<template>
    <div>
      <input type="text" v-model="searchInput" @input="search"/>
      <ul>
        <li v-for="item in filteredBands" :key="item.id">{{ item.name }}</li>
      </ul>
    </div>
  </template>
<script>
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
  