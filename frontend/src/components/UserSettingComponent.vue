<template>
  <div class="settings">
    <h1>User Settings</h1>
  </div>
  <section class="inputSetting">
    <form id="userSettings">
      <label>First name:</label>
      <input
        disabled
        type="text"
        id="firstName"
        name="firstName"
        value="{{FIRSTNAME}}"
      />
      <br />
      <label>Last name:</label>
      <input
        disabled
        type="text"
        id="lastName"
        name="lastName"
        value="{{LASTNAME}}"
      />
      <br />
      <label>Email</label>
      <input disabled type="text" id="email" name="email" value="{{EMAIL}}" />
    </form>
    <form id="passwordSettings">
      <label>Current password</label>
      <input type="password" id="userCurrentPassword" />
      <input type="password" id="userNewPassword1" placeholder="new password" />
      <input
        type="password"
        id="userNewPassword2"
        placeholder="type new password again"
      />
      <br />
      <input type="submit" value="Submit" />
    </form>
  </section>
</template>

<style>
.inputSetting {
  width: 100%;

  display: flex;
  flex-direction: column;
  gap: 16px;
}

#userSettings {
  background-color: lightgrey;
}

#passwordSettings {
  background-color: lightgray;
}

form .form-control,
form .form-control:focus {
  border-color: transparent;
  border-bottom-color: #bebcc1;
  box-shadow: none;
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
