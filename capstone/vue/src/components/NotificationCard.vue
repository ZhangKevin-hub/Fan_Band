<template>
  <div>
    <div
      v-if="Object.keys(this.$store.state.notifications).length !== 0"
      id="card-div"
    >
      <div id="notificationHeader">
        <h3 v-on:click="setCurrentBand(notification.bandId)" id="bandName">
          {{ notification.bandName }}
        </h3>

        <p id="messagedDate">{{ notification.messageDate }}</p>
      </div>

      <p id="messageContent">{{ notification.message }}</p>
    </div>
    <div v-else>
      <h1>Sorry No Notifications</h1>
    </div>
  </div>
</template>

<script>
import AuthService from "../services/AuthService";
export default {
  name: "notificationCard",
  props: {
    notification: Object,
  },
  methods: {
    setCurrentBand(id) {
      AuthService.getBand(id).then((response) => {
        const band = response.data;
        this.$store.commit("SET_CURRENT_BAND", band);
        this.$router.push({ name: "bandPage" });
      });
    },
  },
};
</script>

<style>
#card-div {
  width: 60%;
  margin: 20px;
  border: 5px solid;
  margin-right: auto;
  margin-left: auto;
  margin: 0 15px 0 15px;
  background-color:  rgb(176, 79, 196);
}

#notificationHeader {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: rgb(156, 170, 233);
    border-bottom: 1px inset black;
}

#messageDate {
    text-align: right;
}

#messageContent {
    text-align: center;
}
</style>