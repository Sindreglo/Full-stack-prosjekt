<template>
  <div class="login">
    <h1>LOGIN</h1>
    <form @submit.prevent="login">
      <div>
        <label>Username(email)</label>
        <input v-model="username" placeholder="Username" type="email" />
        <div v-show="submitted && !username" class="invalid-feedback">
          Username is required
        </div>
        <br />
        <br />

        <label>Password</label>
        <input v-model="password" placeholder="Password" type="password" />
        <div v-show="submitted && !password" class="invalid-feedback">
          Password is required
        </div>
        <br />
        <br />
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
import User from "@/model/user";
export default {
  name: "LoginComponent",
  data: () => {
    return {
      user: new User("test@test.com", "test"),
      submitted: false,
    };
  },
  computed: {
    /**loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },*/
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/subjects_page");
    }
  },
  methods: {
    login() {
      this.submitted = true;
      const { username, password } = this;
      const { dispatch } = this.$store;
      if (this.user.username && this.user.password) {
        dispatch("auth/login", { username, password });
        console.log("HIT MEN IKKE LENGER");
      }
    },
  },
};
</script>

<style scoped>
.login {
  width: fit-content;
  block-size: fit-content;
  margin: auto;
}
</style>
