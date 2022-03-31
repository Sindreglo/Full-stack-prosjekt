import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { VueCsvImportPlugin } from "vue-csv-import";

import "@fortawesome/fontawesome-free/js/all";

createApp(App).use(store).use(router).use(VueCsvImportPlugin).mount("#app");
