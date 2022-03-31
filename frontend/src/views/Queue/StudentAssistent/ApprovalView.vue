<template>
  <div id="approvalForm2">
    <h1>Godkjenn {{ studentName }}</h1>
    <div id="radioInput">
      <input
        class="radioItem"
        id="radioItem1"
        type="radio"
        v-model="approve"
        value="0"
      />
      <label for="radioItem1">Godkjent</label>

      <input
        class="radioItem"
        id="radioItem2"
        type="radio"
        v-model="approve"
        value="1"
      />
      <label for="radioItem2">Ikke Godkjent</label>
    </div>
    <router-link id="queueButton" :to="{ name: 'Queue_page' }"
      >Send</router-link
    >
  </div>
</template>

<script>
export default {
  props: ["studentName"],
  data() {
    return {
      approve: "",
    };
  },
};
</script>

<style>
#approvalForm2 {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#radioInput {
  align-items: center;
}
</style>
