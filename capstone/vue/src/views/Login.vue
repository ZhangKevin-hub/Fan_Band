<template>
  <div id="login" class="text-center">      <input type="text" v-model="searchInput" @input="search"/>

  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login {
  text-align: center;
  border: 5px solid;
  border-radius: 25%;
  width:33%;
  margin: auto;
  margin-top: 10%;
}

.form-signin {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 20px;
}

.form-signin * {
  padding: 10px;
}
</style>
