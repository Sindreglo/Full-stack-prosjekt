<template>
  <label>Login here</label><br /><br />
  <div id="loginContainer">
    <form @submit.prevent="handleLogin">
      <div id="username">
        <label>Username(email):</label>
        <input type="email" name="username" v-model="user.username" />
      </div>
      <div id="password">
        <label>Password:</label>
        <input type="password" name="password" v-model="user.password" />
        <br />
      </div>
      <div id="LoginButton">
        <button type="submit">Sign in</button>
      </div>
    </form>
  </div>
</template>

<script>
import User from "@/models/user";
export default {
  name: "LoginView",
  data() {
    return {
      user: new User("", ""),
      error: false,
      message: "",
    };
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }
        if (this.user.username && this.user.password) {
          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$router.push("/subject_page");
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    },
  },
};
</script>
