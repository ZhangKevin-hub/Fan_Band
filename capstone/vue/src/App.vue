<template>
  <div id="app">
    <div id="nav">
      <router-link  v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'search' }" v-if="$store.state.token != ''">Search</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'adminPage' }" v-if="$store.state.token != ''">Admin</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>


.heading
{
    font-family: "Sedgwick Ave Display", "helvetica", cursive;

}
#nav {
  text-align: right;
  border: 5px solid;
  padding: 10px;
}
</style>
