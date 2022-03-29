<template>
  <h1>Kø</h1>
  <div class="container">
    <table class="table">
      <thead>
        <th>Student</th>
        <th>Øving</th>
        <th>Type</th>
        <th>Sted</th>
        <th>Tid</th>
      </thead>
      <tbody>
        <tr v-for="(student, index) in users" v-bind:key="index">
          <td>{{ student.name }}</td>
          <td>{{ student.exercise }}</td>
          <td>{{ student.type }}</td>
          <td>{{ student.place }}</td>
          <td>{{ student.Time }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
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
.table {
  width: 100%;
}
</style>
