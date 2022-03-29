import { createRouter, createWebHistory } from "vue-router";
import Subjects_page from "@/views/subjects/Subjects_page";
import Subject_Details from "@/views/subjects/Subject_Details";
import UserSettings from "@/views/UserSettings";
import LoginView from "@/views/LoginView";
import NewApproval from "@/views/Queue/NewApproval";
import Queue_page from "@/views/Queue/Queue_page";

const routes = [
  {
    path: "/subjects_page",
    name: "Subjects",
    component: Subjects_page,
  },
  {
    path: "/subject_details",
    name: "Subject_Details",
    props: true,
    component: Subject_Details,
  },
  {
    path: "/user_Setting",
    name: "User_Setting",
    component: UserSettings,
  },
  {
    path: "/login",
    name: "Login_view",
    component: LoginView,
  },
  {
    path: "/newApproval",
    name: "NewApproval",
    props: true,
    component: NewApproval,
  },
  {
    path: "/Queue_page",
    name: "Queue_page",
    component: Queue_page,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
