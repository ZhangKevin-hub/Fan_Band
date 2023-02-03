<template>
    <div>
      <input type="text" v-model="searchInput" @input="search"/>
      <ul>
        <li v-for="band in filteredBands" :key="band.id">{{ band.name }}</li>
      </ul>
    </div>
  </template>
<script>

</script>