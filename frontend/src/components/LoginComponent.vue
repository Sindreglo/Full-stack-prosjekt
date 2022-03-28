<template>
  <label>Login here</label><br /><br />
  <div id="loginContainer">
    <form @submit.prevent="onSubmit">
      <div id="username">
        <label>Username:</label>
        <input type="text" id="usernameID" name="username" v-model="username" />
      </div>
      <div id="password">
        <label>Password:</label>
        <input
          type="password"
          id="passwordID"
          name="password"
          v-model="password"
        />
        <br />
      </div>
      <div id="LoginButton">
        <button type="submit" v-on:click="handleClickSignin">Sign in</button>
      </div>
      <p v-show="notReg">
        Not registered yet! <router-link to="/register">Register</router-link>
      </p>
      <div v-if="falsePassword">Wrong password. Try again</div>
    </form>
  </div>
</template>

<script></script>
