<template>
  <div v-if="subject">
    <h1>{{ subject.title }}</h1>
    <p>{{ subject.description }}</p>
  </div>
</template>

<script>
export default {
  props: ["id"],
  created() {
    this.$store.dispatch("fetchSubject", this.id).catch((error) => {
      this.$router.push({
        name: "ErrorDisplay",
        params: { error: error },
      });
    });
  },
  computed: {
    subject() {
      return this.$store.state.subject;
    },
  },
};
</script>
