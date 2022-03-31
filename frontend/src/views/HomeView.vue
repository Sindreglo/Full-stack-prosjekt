<template>
  <div class="home">
    <Subject />
  </div>
</template>

<script>
// @ is an alias to /src
import Subject_box from "@/components/boxes/Subject_box.vue";

export default {
  name: "HomeView",
  components: {
    Subject: Subject_box,
  },
};
</script>
