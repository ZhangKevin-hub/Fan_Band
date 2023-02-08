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
.heading{
  font-family: 'Sedgwick Ave Display', cursive;
   font-size: 36px;

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

.heading{
  background-image: linear-gradient(rgb(156, 170, 233), rgb(176, 79, 196));
  width: 35%;
  margin: auto;
  margin-top: auto ;
  border-style: ridge;
  margin-bottom: 10px;
  margin-top: 10px;
  
  
}

#login, #newBandForm{
  text-align: center;
  border: 5px solid;
  border-radius: 25%;
  width: 33%;
  margin: auto;
  margin-top: 10%;
}

@media (max-width: 768px) {
  #login, #newBandForm {
    width: 80%;
    margin-top: 5%;
  }
}
</style>
