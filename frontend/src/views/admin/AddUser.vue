<template>
  <form class="createSubject">
    <h1>Legg til ny bruker</h1>
    <div>
      <h3>Navn:</h3>
      <input class="inputField" v-model="subjectName" placeholder="navn" />
    </div>
    <div>
      <h3>Epost:</h3>
      <input class="inputField" v-model="subjectCode" placeholder="epost" />
    </div>
    <div>
      <h3>Type:</h3>
      <input class="inputField" v-model="type" placeholder="student" />
    </div>
    <button id="addUser" v-on:click="addUser">Legg til Bruker</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      subjectName: "",
      subjectCode: "",
      type: "",
    };
  },
  methods: {
    addUser() {},
  },
};
</script>

<style>
#addUser {
  color: inherit;
  background: white;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin-top: 20px;
  font-size: 20px;
  padding: 7px;
  width: 200px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#addUser:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
