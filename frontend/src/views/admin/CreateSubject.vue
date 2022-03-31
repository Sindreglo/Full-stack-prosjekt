<template>
  <form id="createSubject">
    <h1>Opprett nytt fag</h1>
    <div>
      <h3>Navn på fag:</h3>
      <input class="inputField" v-model="subjectName" placeholder="fagnavn" />
    </div>
    <div>
      <h3>Fagkode:</h3>
      <input class="inputField" v-model="subjectCode" placeholder="fagkode" />
    </div>
    <div>
      <h3>Antall Øvinger:</h3>
      <input
        class="inputField"
        type="number"
        min="0"
        step="1"
        placeholder="0"
      />
    </div>
    <div>
      <h3>Importer CSV studenter</h3>
      <textarea></textarea>
    </div>
    <button id="addUser" v-on:click="csvToJson">Legg til</button>
  </form>
</template>

<script>
import papa from "papaparse";
export default {
  data() {
    return {
      subjectName: "",
      subjectCode: "",
      tasks: 0,
      csvData: [],
    };
  },
  methods: {
    csvToJson() {
      let csvFile = this.$refs.file.files[0];

      if (csvFile === undefined) {
        alert("Velg en fil!");
        this.csvData = [];
        return;
      }
      let that = this;
      papa.parse(csvFile, {
        header: true,
        dynamicTyping: true,
        skipEmptyLines: true,
        complete(result) {
          that.csvData = result.data;
        },
      });
    },
  },
};
</script>

<style>
#createSubject {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.inputField {
  width: 200px;
  border: black 1px solid;
  margin-bottom: 20px;
}

textarea {
  min-width: 300px;
  min-height: 100px;
}
</style>
