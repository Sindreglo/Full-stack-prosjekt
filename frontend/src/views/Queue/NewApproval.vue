<template>
  <h1>{{ subject.title }}</h1>
  <div>
    <form id="approvalForm" @submit.prevent="sendForm">
      <h3>Øvinger:</h3>
      <div>
        <select class="selectInput" v-model="tasks">
          <option disabled value="">Velg øving</option>
          <option v-for="task in subject.task" :key="task.task">
            {{ task.name }}
          </option>
        </select>
      </div>
      <h3>Type:</h3>
      <div id="radioInput">
        <input
          class="radioItem"
          id="radioItem1"
          type="radio"
          v-model="type"
          value="0"
        />
        <label for="radioItem1">Godkjenning</label>

        <input
          class="radioItem"
          id="radioItem2"
          type="radio"
          v-model="type"
          value="1"
        />
        <label for="radioItem2">Hjelp</label>
      </div>
      <h3>Hvor:</h3>
      <div id="typeInput">
        <input
          class="typeItem"
          id="typeItem1"
          type="radio"
          v-model="where"
          value="Klasserom"
        />
        <label for="radioItem1">Klasserom</label>

        <input
          class="typeItem"
          id="typeItem2"
          type="radio"
          v-model="where"
          value="Digitalt"
        />
        <label for="radioItem2">Digitalt</label>
      </div>
      <div id="dropList" v-show="where === 'Klasserom'">
        <h3>bord nummer:</h3>
        <select class="selectInput" v-model="selected">
          <option disabled value="">Velg bord</option>
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
          <option>6</option>
          <option>7</option>
        </select>

        <p>Valgt bord: {{ selected }}</p>
        <img id="Room_img" src="@/assets/Room.png" alt="Room" />
      </div>
      <router-link id="queueButton" :to="{ name: 'Queue_page' }"
        >Still i kø</router-link
      >
    </form>
  </div>
</template>

<script>
export default {
  props: ["id"],
  data() {
    return {
      type: "",
      where: "",
      tasks: "",
      selected: "",
    };
  },
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
#approvalForm {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#radioInput {
  width: 200px;
  display: grid;
  grid-template-areas: "radioItem1 radioItem2";
  grid-template-columns: 50% 50%;
}

#typeInput {
  width: 200px;
  display: grid;
  grid-template-areas: "typeItem1 typeItem2";
  grid-template-columns: 50% 50%;
}

.radioItem {
  height: 25px;
  margin-bottom: 20px;
}

.typeItem {
  height: 25px;
}

section {
  width: 300px;
}

#queueButton {
  padding: 10px;
  width: 150px;
  cursor: pointer;
  border: 1px solid #39495c;
  margin-top: 40px;
}

#dropList {
  margin-top: 40px;
}

#Room_img {
  height: 400px;
}

.selectInput {
  text-align: center;
  color: inherit;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  font-size: 15px;
  padding: 7px;
  width: 140px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#queueButton {
  color: inherit;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin-top: 20px;
  font-size: 20px;
  padding: 7px;
  width: 200px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#queueButton:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
