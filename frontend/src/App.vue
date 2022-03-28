<template>
  <nav>
    <h1>Qs3</h1>
    <router-link to="/subjects_page">Fag</router-link>
    <br />
    <router-link to="/about">About</router-link>
    <br />
    <router-link to="/user_Setting">Settings</router-link>
    <br />
    <router-link to="/login">Login</router-link>
    <br />
    <a>Logg ut</a>
  </nav>
  <div id="view">
    <router-view />
  </div>
</template>

<style>
#app {
  display: grid;
  width: 100%;
  height: 98vh;
  grid-template-areas: "nav view";
  grid-template-rows: 100%;
  grid-template-columns: 25% 75%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

h1 {
  font-size: 50px;
}

nav {
  grid-area: nav;
  color: white;
  font-size: 20px;
  background-image: linear-gradient(to right, #008b8b, #006565);
}

nav a {
  font-weight: bold;
  color: white;
}

#view {
  grid-area: view;
}
</style>
