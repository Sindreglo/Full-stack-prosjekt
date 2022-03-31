<template>
  <h1>Admin panel</h1>
  <form id="adminPanel">
    <div id="subjectTable">
      <Subject
        v-for="subject in subjects"
        :key="subject.id"
        :subject="subject"
      />
    </div>
    <div id="userTable">
      <Users v-for="(user, i) in users" :key="i" :user="user" />
    </div>
  </form>
</template>

<script>
// @ is an alias to /src
import Subject from "@/components/boxes/Subject_box";
import Users from "@/components/boxes/User_box";

export default {
  components: {
    Subject,
    Users,
  },
  created() {
    this.$store.dispatch("fetchSubjects").catch((error) => {
      this.$router.push({
        name: "ErrorDisplay",
        params: { error: error },
      });
    });
    this.$store.dispatch("fetchUsers").catch((error) => {
      this.$router.push({
        name: "ErrorDisplay",
        params: { error: error },
      });
    });
  },
  computed: {
    subjects() {
      return this.$store.state.subjects;
    },
    users() {
      return this.$store.state.users;
    },
  },
};
</script>

<style>
#adminPanel {
  display: grid;
  flex-direction: column;
  text-align: left;
  grid-template-areas: "subjectTable userTable";
  margin-left: 80px;
}

#userTable {
  text-align: left;
}
</style>
