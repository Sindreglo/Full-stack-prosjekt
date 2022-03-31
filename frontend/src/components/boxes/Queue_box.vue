<template>
  <div class="queue-card">
    <h2>{{ user.username }} - {{ user.Time }}</h2>
    <p>{{ user.exercise }} {{ user.type }}</p>
    <p>{{ user.place }}</p>
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
.queue-card:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
