<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'search' }"
        v-if="$store.state.token != ''"
        >Search</router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'adminPage' }"
        v-if="$store.state.token != ''"
        >Admin</router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: "Itim", cursive;
  /* background-image: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119)); */
  background-image: linear-gradient(to bottom right, rgb(156, 170, 233), rgb(176, 79, 196));
  height: 100vh;
}
#div{
  font-family: 'Sedgwick Ave Display', cursive;
}
/* body {
  background-color: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119));
} */
#nav {
  text-align: right;
  border: 5px solid;
  padding: 10px;
}
</style>
