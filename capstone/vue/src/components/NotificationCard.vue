<template>
  <div id="card-div"> <!--v-if notification has content -->
      <h3>Band Name  <!--{{ notification.bandName }}--> </h3>
      <p>Date <!--{{ notification.date }}--></p>
      <p>Content <!--{{ notification.post }}--></p>
  </div>
  <!-- v-else blank - say "no posts to display" -->
</template>

<script>
export default {
    name: 'notificationCard'
    //props: ['notification']
}
</script>

<style>
#card-div {
    width: 60%;
    margin: 20px;
    border: 5px solid;
    margin-right: auto;
    margin-left: auto;
}

</style>