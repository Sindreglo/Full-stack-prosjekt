<template>
  <h1>Vil du logge ut?</h1>
  <button id="logout" v-on:click="logoutUser">Logg ut</button>
</template>

<script>
import store from "@/store";

export default {
  methods: {
    logoutUser() {
      store.commit("SET_LEVEL", 3);
      this.$router.push("login");
    },
  },
};
</script>

<style>
#logout {
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

#logout:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
