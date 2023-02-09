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
  /* width: 60%; */
  margin: 20px;
  border: 5px solid;
  margin-right: auto;
  margin-left: auto;
  margin: 20px 15px 20px 15px;
  background-color: rgb(176, 79, 196);
  border-radius: 10px;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
}

#notificationHeader {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: rgb(156, 170, 233);
    border-bottom: 1px solid rgba(0, 0, 0, 0.2);
    padding: 10px 20px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}


#messageDate {
    text-align: right;
}

#messageContent {
    text-align: center;
}
</style>