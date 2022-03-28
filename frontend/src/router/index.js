import { createRouter, createWebHistory } from "vue-router";
import Subjects_page from "@/views/subjects/Subjects_page";
import Subject_Details from "@/views/subjects/Subject_Details";

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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
