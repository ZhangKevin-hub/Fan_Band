<template>
  <div id="app">
    <div id="nav">
      <span>Fan Band</span>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#nav{
  text-align: right;
  border: 5px solid;
  padding: 10px;
}
span {
  padding-right: 42%;
}

</style>
