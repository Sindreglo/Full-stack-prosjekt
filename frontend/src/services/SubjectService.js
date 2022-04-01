import axios from "axios";
axios.defaults.headers.common["Authorization"] =
  "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHVkZW50IiwiZXhwIjoxNjQ4ODU3NDYxLCJpYXQiOjE2NDg4MjE0NjF9.iqnTnnU4Pc91hIAn9l_a5q5F2su3siC4wFGsRQJCDsE";

let apiClient = axios.create({
  mode: "no-cors",
  baseURL: "http://localhost:8081/api",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  getSubjects() {
    return apiClient.get("/course");
  },
  getSubject(id) {
    return apiClient.get("/subjects/" + id);
  },
  postSubject(event) {
    return apiClient.post("/subjects", event);
  },
  getUsers() {
    return apiClient.get("/users");
  },
};
