<template class= "container">
  <div id="app">
    <div id="nav">
      <div class="spacer2">&nbsp;</div>
      <img id= "logo" src="./assets/images/fanband.png" alt="fanbandlogo" />
    <ul class="navButtons">
      <li>
      <button>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      </li>
      <li>
      <button v-if="$store.state.token != ''">
        <router-link
          v-bind:to="{ name: 'search' }"
          >Search</router-link
        >
      </button>
      </li>
      <li>
      <button v-if="$store.state.user.id === 1">
        <router-link
          v-bind:to="{ name: 'adminPage' }"
          >Admin</router-link
        >
      </button>
      </li>
      <li>
      <button v-if="$store.state.token != ''">
        <router-link
          v-bind:to="{ name: 'logout' }"
          >Logout</router-link
        >
      </button>
      </li>
    </ul>
    </div>
    <div id="placeholder"></div>
    <router-view/>
  </div>
</template>

<style>

#app {
  font-family: "Itim", cursive;

  background-image: linear-gradient(
    to bottom right,
    rgb(156, 170, 233),
    rgb(176, 79, 196)
  );
  height: 100vh;

}

.navButtons{
  width: 33%;
  display: flex;
  font-family: "Sedgwick Ave Display", cursive;
  font-size: 1.2em;
  

}



.heading {
  font-family: "Sedgwick Ave Display", cursive;
  font-size: 36px;
}
/* body {
 
} */
#nav {
   
  border: 3px solid;
  align-items: center;
  width: 100%;
  height: 80px;
  box-sizing: border-box;
  background-color:rgb(101, 11, 119);
  box-shadow: 03px 4px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  /* margin-bottom: 20px; */
  position: fixed;
  top:0%;
 /* background-color: linear-gradient(to bottom right, rgb(29, 56, 175), rgb(101, 11, 119)); */

}
#placeholder {
  height: 71px;
  width: 100%;
}

#nav, ul{
  display: flex;
  /* flex-direction: row; */
  justify-content: space-between;

}

ul{
  flex-direction: row;
  justify-content: flex-end;
}



.spacer2{
  width: 33%;
}


#logo {
  /* margin-top: 18px; */
  width:105px
 
}

ul {
    margin: 0;
    padding: 0;
    list-style-type: none;
}

/* #app{
  display:block;
} */

ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
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
#newBandForm{
  padding: 3%;
  text-align: center;
  border: 7px solid;
  border-radius: 25%;
  width: 25%;
  min-height:auto;
  margin: auto;
  background-color: mediumorchid;
}






@media (max-width: 768px) {
  #login,
  #newBandForm {
    width: 80%;
    margin-top: 5%;
  }
}

button {
  color: white;
  padding: 8px 15px;
  border: none;
  border-radius: 25px;
  cursor: pointer;
  font-size: 14px;
  margin-left: 10px;
  
}

button:hover {
background-color:  rgb(0, 255, 255);
}
</style>


