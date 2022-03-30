<template>
  <div v-if="subject">
    <h1>{{ subject.title }}</h1>
    <p>{{ subject.description }}</p>
    <router-link
      id="GoToQueue"
      :to="{ name: 'NewApproval', params: { id: subject.id } }"
      >Gå til kø</router-link
    >
    <table id="example-1">
      <tbody v-for="task in subject.task" :key="task.task">
        <div id="tasks">
          <td v-if="task.status === 1">
            <img
              class="check_img"
              src="@/assets/Approval/approved.png"
              alt="Godkjent"
            />
          </td>
          <td v-if="task.status === 2">
            <img
              class="check_img"
              src="@/assets/Approval/failed.png"
              alt="Underkjent"
            />
          </td>
          <td v-if="task.status === 0">
            <img
              class="check_img"
              src="@/assets/Approval/waiting.png"
              alt="Ikkevurdert"
            />
          </td>
          <td>
            <label>{{ task.name }}</label>
          </td>
        </div>
      </tbody>
    </table>
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

<style>
#example-1 {
  list-style-type: none;
  display: flex;
  flex-direction: column;
  align-items: center;
}

#tasks {
  margin-top: 20px;
  font-size: 20px;
  padding: 10px;
  width: 250px;
  cursor: pointer;
  border: 1px solid #39495c;
}

td {
  width: 100px;
}

.check_img {
  height: 20px;
}

#GoToQueue {
  color: inherit;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin-top: 20px;
  font-size: 20px;
  padding: 7px;
  width: 200px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#GoToQueue:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
