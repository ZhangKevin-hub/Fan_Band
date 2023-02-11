<template>
    <div>
      <search-list></search-list>
    </div>
  </template>

  <script>
    import SearchList from '../components/SearchList.vue'
    
      export default {
        name: 'Search',
      components: {
        SearchList
      }
  }
  </script>
  <style scoped>

  div {
    background-image: url("../assets/images/livecrowd1.jpg");
  background-size: 100%;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  min-height: 100%;
  width: 100vw;
  }
  </style>