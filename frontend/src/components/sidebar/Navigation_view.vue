<template>
  <div class="sidebar" :style="{ width: sidebarWidth }">
    <h1>
      <span v-if="collapsed">
        <div>Qs</div>
        <div>3</div>
      </span>
      <span v-else>Qs 3</span>
    </h1>
    <div v-if="admin === 1 || admin === 2">
      <sidebarLink v-if="admin === 1" to="/AdminView" icon="fa-solid fa-lock"
        >Admin</sidebarLink
      >
      <sidebarLink
        v-if="admin === 1"
        to="/AddUser"
        icon="fa-solid fa-circle-plus"
        >Legg til bruker</sidebarLink
      >
      <sidebarLink
        v-if="admin === 1"
        to="/CreateSubject"
        icon="fa-solid fa-circle-plus"
        >Opprett fag</sidebarLink
      >
      <SidebarLink to="/subjects_page" icon="fa-solid fa-book">Fag</SidebarLink>
      <SidebarLink to="/user_Setting" icon="fas fa-tools">Settings</SidebarLink>
      <SidebarLink to="/logout" icon="fa-solid fa-right-from-bracket"
        >Logg ut</SidebarLink
      >
    </div>
    <SidebarLink
      v-if="admin === 3"
      to="/login"
      icon="fa-solid fa-right-from-bracket"
      >logg inn</SidebarLink
    >

    <span
      class="collapse-icon"
      :class="{ 'rotate-180': collapsed }"
      @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
  </div>
</template>

<script>
import store from "@/store";
import SidebarLink from "./NavigationLink";
import { collapsed, toggleSidebar, sidebarWidth } from "./state";

export default {
  props: {},
  components: { SidebarLink },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth };
  },
  computed: {
    admin() {
      return store.state.user.username.userLevel.id;
    },
  },
};
</script>

<style>
:root {
  --sidebar-bg-color: #008b8b;
  --sidebar-item-hover: #006c6c;
  --sidebar-item-active: #00a5a5;
}
</style>

<style scoped>
.sidebar {
  color: white;
  background-color: var(--sidebar-bg-color);

  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;

  transition: 0.3s ease;

  display: flex;
  flex-direction: column;
}

.sidebar h1 {
  height: 2.5em;
}

.collapse-icon {
  position: absolute;
  top: 0;
  padding: 0.75em;

  color: rgba(255, 255, 255, 0.7);

  transition: 0.2s linear;
}

.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
</style>
