<template>
  <div>
    <h1>LOGIN</h1>
    <form @submit.prevent="login">
      <div>
        <label>Username(email)</label>
        <input v-model="username" placeholder="Username(email)" type="email" />
        <div v-show="submitted && !username" class="invalid-feedback">
          Username is required
        </div>
        <br />
        <br />
      </div>
      <div>
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
export default {
  data: () => {
    return {
      username: "",
      password: "",
      submitted: false,
    };
  },
  computed: {
    loggingIn() {
      return this.$store.state.authentication.status.loggingIn;
    },
  },
  created() {
    //reset login status
    this.$store.dispatch("authentication/logout");
  },
  methods: {
    login() {
      this.submitted = true;
      const { username, password } = this;
      const { dispatch } = this.$store;
      if (username && password) {
        dispatch("authentication/login", { username, password });
      }
    },
  },
};
</script>
