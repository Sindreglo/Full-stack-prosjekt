import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:3000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  getSubjects() {
    return apiClient.get("/subjects");
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
