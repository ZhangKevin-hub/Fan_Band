<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div>
      <label for="username" class="sr-only">Username:</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <div>
      <label for="password" class="sr-only">Password:</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
         v-on:blur="unBlurCheck()"
      />
      <p v-if="this.unBlur">Password must contain{{ checkPassword }}.</p>
      <!-- blur - move away -->
      </div>
      <div>
      <label for="confirmPassword" class="sr-only">Confirm Password:</label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      
      </div>
      <label for="isManager">Are you a band manager? </label>
      <input type="checkbox" id="isManager" v-on:checked="changeRole()">
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
      unBlur: false
    };
  },
  computed: {
    checkPassword(){
      let passwordMessage = "";
      //const passwordValidator = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$";
      // separate statements ("you need a lowercase") multiple messages
      if (!this.user.password.match(/[a-z]/)){
        passwordMessage += " a lowercase letter"
      }
      
      if (!this.user.password.match(/[A-Z]/)){
        passwordMessage += " an uppercase letter"
      } 
      if (!this.user.password.match(/\d/)){
        passwordMessage += " a number"
      } 
      if (!this.user.password.length >= 8){
        passwordMessage += " 8 or more characters long"
      }
      return passwordMessage;
    }
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    changeRole(){
      if (this.user.role === 'user'){
        this.user.role = 'manager';
        console.log(this.user.role)
      } else {
        this.user.role = 'user';
      }
    },
    unBlurCheck(){
      this.unBlur = true;
    }
  },
};
</script>

<style scoped>
#register {
  text-align: center;
  border: 5px solid;
  border-radius: 25%;
  width:33%;
  margin: auto;
  margin-top: 10%;
}

.form-register {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 20px;
}

.form-register * {
  padding: 10px;
}
</style>
