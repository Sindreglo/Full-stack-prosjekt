<template>
  <form id="createSubject">
    <h1>Logg inn</h1>
    <div>
      <h3>brukernavn:</h3>
      <input class="inputField" v-model="user.username" placeholder="navn" />
    </div>
    <div>
      <h3>Passord:</h3>
      <input class="inputField" v-model="user.password" placeholder="epost" />
    </div>
    <button id="addUser" v-on:click="handleLogin">Logg inn</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    handleLogin() {
      if (this.user.username && this.user.password) {
        this.$store.dispatch("login", this.user).then(
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
    },
  },
};
</script>

<style>
#addUser {
  color: inherit;
  background: white;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin-top: 20px;
  font-size: 20px;
  padding: 7px;
  width: 200px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#addUser:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}

input {
  -ms-flex-order: 2;
  order: 2;
  display: block;
  margin-top: 0;
  background: 0 0;
  padding: 2px 2px 1px;
  border-width: 0 0 1px;
  line-height: 26px;
  height: 30px;
  border-radius: 0;
  border-style: solid;
  width: 100%;
  box-sizing: border-box;
  float: left;
}
</style>
