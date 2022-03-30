<template>
  <div class="queue">
    <h1>Kø</h1>
    <div id="userTable">
      <Users v-for="(user, i) in users" :key="i" :user="user" />
    </div>
  </div>
</template>

<script>
import Users from "@/components/boxes/Queue_box";

export default {
  components: {
    Users,
  },
  created() {
    this.$store.dispatch("fetchUsers").catch((error) => {
      this.$router.push({
        name: "ErrorDisplay",
        params: { error: error },
      });
    });
  },
  computed: {
    users() {
      return this.$store.state.users;
    },
  },
};
</script>

<style>
.queue {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
