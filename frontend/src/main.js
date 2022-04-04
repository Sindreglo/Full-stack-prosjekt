import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VeeValidate from "vee-validate";

import "@fortawesome/fontawesome-free/js/all";

createApp(App).use(store).use(VeeValidate).use(router).use().mount("#app");
