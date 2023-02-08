<template>
  <div id="app">
    <div id="nav">
      <img src="./assets/images/fanband.png" alt="fanbandlogo" />
      <button>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      <button v-if="$store.state.token != ''">
        <router-link
          v-bind:to="{ name: 'search' }"
          >Search</router-link
        >
      </button>
      <button v-if="$store.state.user.id === 1">
        <router-link
          v-bind:to="{ name: 'adminPage' }"
          >Admin</router-link
        >
      </button>
      <button v-if="$store.state.token != ''">
        <router-link
          v-bind:to="{ name: 'logout' }"
          >Logout</router-link
        >
      </button>
    </div>
    <router-view/>
  </div>
</template>

<style>

#app {
  font-family: "Itim", cursive;
  /* background-image: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119)); */
  background-image: linear-gradient(
    to bottom right,
    rgb(156, 170, 233),
    rgb(176, 79, 196)
  );
  height: 100vh;

}
.heading {
  font-family: "Sedgwick Ave Display", cursive;
  font-size: 36px;
}
/* body {
  background-color: linear-gradient
    (to the bottom right, rgb(29, 56, 175), rgb(101, 11, 119));
} */
#nav {
  text-align: right;
  height: 50px;
  border: 5px solid;
  padding: 10px;
}
img {
  height: 40px;
}

.heading {
  background-image: linear-gradient(rgb(156, 170, 233), rgb(176, 79, 196));
  width: 35%;
  margin: auto;
  margin-top: auto;
  border-style: ridge;
  margin-bottom: 25px;
}

#login,
#newBandForm {
  padding: 3%;
  text-align: center;
  border: 7px solid;
  border-radius: 25%;
  width: 33%;
  min-height: 100%;

  /* margin-top: 10%; */
}



@media (max-width: 768px) {
  #login,
  #newBandForm {
    width: 80%;
    margin-top: 5%;
  }
}
</style>
