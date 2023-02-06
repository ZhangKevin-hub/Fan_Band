<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'search' }" v-if="$store.state.token != ''">Search</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'adminPage' }" v-if="$store.state.token != ''">Admin</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#app {
  font-family: "Sedgwick Ave Display", "helvetica", cursive;
   background-image: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119));
}
#body {
  background-image: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119));
}
#nav {
  text-align: right;
  border: 5px solid;
  padding: 10px;
}
</style>
