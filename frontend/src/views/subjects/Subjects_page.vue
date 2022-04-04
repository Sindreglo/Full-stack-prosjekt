<template>
  <h1>Fag</h1>
  <div class="events">
    <Subject
      v-for="subject in AllSubjects.teacher"
      :key="subject.id"
      :subject="subject"
    />
    <Subject
      v-for="subject in AllSubjects.assistant"
      :key="subject.id"
      :subject="subject"
    />
    <Subject
      v-for="subject in AllSubjects.student"
      :key="subject.id"
      :subject="subject"
    />
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
    AllSubjects() {
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
