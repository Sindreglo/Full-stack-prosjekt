<template>
  <div class="settings">
    <h1>USER SETTING</h1>

    <section class="inputSetting">
      <form id="userSettings">
        <label>First name:</label>
        <input
          disabled
          type="text"
          id="firstName"
          name="firstName"
          v-model="user.firstName"
        />
        <br />
        <label>Last name:</label>
        <input
          disabled
          type="text"
          id="lastName"
          name="lastName"
          v-model="user.lastName"
        />
        <br />
        <label>Email</label>
        <input
          disabled
          type="email"
          id="email"
          name="email"
          v-model="user.email"
        />
      </form>
      <form @submit.prevent="checkAndChangePassword" id="passwordSettings">
        <label>Change password</label>
        <input type="password" id="CurrentPassword" v-model="user.password" />
        <input
          type="password"
          id="newPassword"
          placeholder="new password"
          v-model="user.newPassword"
        />
        <input
          type="password"
          id="verifyNewPassword"
          placeholder="verify new password"
          v-model="user.verifyNewPassword"
        />
        <br />
        <button type="submit">Change password</button>
        <div id="alert" v-if="alert">{{ user.alert }}</div>
      </form>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        firstName: "Test",
        lastName: "Testesen",
        email: "test@test.com",
        password: "Test123",
        newPassword: "",
        verifyNewPassword: "",
        alert: "",
      },
    };
  },
  methods: {
    checkAndChangePassword() {
      console.log("HEI");
      if (this.newPassword !== this.verifyNewPassword) {
        this.alert = "Passwords must match";
        return this.alert;
      }
    },
  },
};
</script>

<style>
.inputSetting {
  width: 100%;

  display: flex;
  flex-direction: column;
  gap: 16px;
}

input {
  -ms-flex-order: 2;
  order: 2;
  display: block;
  margin-top: 0;
  background: 0 0;
  padding: 2px 2px 1px;
  border-width: 0 0 1px;
  line-height: 26px;
  height: 30px;
  border-radius: 0;
  border-style: solid;
  width: 100%;
  box-sizing: border-box;
  float: left;
}

.settings {
  width: fit-content;
  block-size: fit-content;
  margin: auto;
}
</style>
