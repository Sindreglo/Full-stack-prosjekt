<template>
  <form class="createSubject" @submit.prevent="handleLogin">
    <h1>Logg inn</h1>
    <div>
      <h3>brukernavn:</h3>
      <input class="inputField" v-model="user.username" placeholder="navn" />
    </div>
    <div>
      <h3>Passord:</h3>
      <input class="inputField" v-model="user.password" placeholder="epost" />
    </div>
    <button id="addUser">Logg inn</button>
  </form>
</template>

<script>
import auth from "@/services/auth.service";
import authHeader from "@/services/auth-header";
import store from "@/store/index.js";
import router from "@/router";

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
    async created() {
      auth.login(this.user);
      // POST request using fetch with async/await
    },
    handleLogin() {
      this.created();
      if (authHeader()) {
        setTimeout(() => {
          if (store.state.level !== 3) {
            store.dispatch("fetchUser");
            router.push("/subjects_page");
          }
        }, 100);
      }
      console.log(authHeader());
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
