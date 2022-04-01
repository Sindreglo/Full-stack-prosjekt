<template>
  <div class="queue-card">
    <h2>{{ user.username }} - {{ user.Time }}</h2>
    <p>{{ user.exercise }} {{ user.type }}</p>
    <p>{{ user.place }}</p>
    <router-link
      v-show="admin === 1"
      class="subject-link"
      :to="{ name: 'ApprovalView', params: { studentName: user.username } }"
      >Vurder student
    </router-link>
  </div>
</template>

<script>
export default {
  props: {
    user: {
      type: Object,
      required: true,
    },
  },
  computed: {
    admin() {
      return this.$store.state.test;
    },
  },
};
</script>

<style scoped>
.queue-card {
  padding-left: 10px;
  width: 250px;
  cursor: pointer;
  border: 1px solid #39495c;
  margin-bottom: 18px;
}

.subject-link {
  color: #008b8b;
}
</style>
