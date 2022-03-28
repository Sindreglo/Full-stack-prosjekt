<template>
  <router-link
    class="subject-link"
    :to="{ name: 'Subject_Details', params: { id: subject.id } }"
  >
    <div class="subject-card">
      <h2>{{ subject.title }}</h2>
      <p>{{ subject.description }}</p>
    </div>
  </router-link>
</template>

<script>
export default {
  props: {
    subject: {
      type: Object,
      required: true,
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.subject-card {
  padding: 20px;
  width: 250px;
  cursor: pointer;
  border: 1px solid #39495c;
  margin-bottom: 18px;
}
.subject-card:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
.subject-link {
  color: #2c3e50;
  text-decoration: none;
}
</style>
