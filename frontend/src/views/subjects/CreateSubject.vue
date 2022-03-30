<template>
  <form id="createSubject">
    <h1>Opprett nytt fag</h1>
    <div>
      <h3>Navn på fag:</h3>
      <input class="inputField" v-model="subjectName" placeholder="edit me" />
    </div>
    <div>
      <h3>Fagkode:</h3>
      <input class="inputField" v-model="subjectCode" placeholder="edit me" />
    </div>
    <div>
      <h3>Antall Øvinger:</h3>
      <select class="selectInput" v-model="tasks">
        <option disabled value="">Antall</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
      </select>
    </div>
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
}
</style>
