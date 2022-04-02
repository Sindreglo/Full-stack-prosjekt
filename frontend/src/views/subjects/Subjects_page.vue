<template>
  <h1>Fag</h1>
  <div class="events">
    <Subject v-for="(subject, i) in subjects" :key="i" :subject="subject" />
  </div>
</template>

<script>
// @ is an alias to /src
import Subject from "@/components/boxes/Subject_box";

export default {
  components: {
    Subject,
  },
  created() {
    this.$store.dispatch("fetchSubjects");
  },
  computed: {
    subjects() {
      return this.$store.state.subjects;
    },
  },
};
</script>

<style>
.events {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
