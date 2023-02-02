<template>
    <div>
      <input type="text" v-model="searchInput" @input="search"/>
      <ul>
        <li v-for="item in filteredList" :key="item">{{ item }}</li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    computed: {
      filteredList() {
        return this.$store.state.band.list.filter(item => {
          return item.includes(this.searchInput);
        });
      }
    },
    data() {
      return {
        searchInput: ''
      }
    },
    methods: {
    search() {
        const searchTerm = this.searchInput.toLowerCase();
        this.$store.commit('SET_CURRENT_BAND', {
        list: this.$store.state.band.list.filter(item => {
            return item.toLowerCase().includes(searchTerm);
        })
        });
        }
    }
  };
  </script>
  