<template>
  <form id="createSubject">
    <h1>Innstillinger</h1>
    <div>
      <h3>Fornavn:</h3>
      <input
        disabled
        class="inputField"
        v-model="user.firstName"
        placeholder="navn"
      />
    </div>
    <div>
      <h3>Etternavn:</h3>
      <input
        disabled
        class="inputField"
        v-model="user.lastName"
        placeholder="navn"
      />
    </div>
    <div>
      <h3>Epost:</h3>
      <input
        disabled
        class="inputField"
        v-model="user.email"
        placeholder="epost"
      />
    </div>
    <form @submit.prevent="checkAndChangePassword" id="createSubject">
      <h3>Change password</h3>
      <input type="password" class="inputField" v-model="user.password" />
      <input
        type="password"
        class="inputField"
        placeholder="new password"
        v-model="user.newPassword"
      />
      <input
        type="password"
        class="inputField"
        placeholder="verify new password"
        v-model="user.verifyNewPassword"
      />
      <br />
      <button id="ChangePassword" type="submit">Change password</button>
    </form>
  </form>
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
      this.alert = "";
      if (this.newPassword !== this.verifyNewPassword) {
        this.alert = "Passwords must match";
        return;
      }
    },
  },
};
</script>

<style>
#ChangePassword {
  color: inherit;
  background: white;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin-bottom: 20px;
  font-size: 20px;
  padding: 7px;
  width: 200px;
  cursor: pointer;
  border: 1px solid #39495c;
}

#ChangePassword:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
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
</style>
