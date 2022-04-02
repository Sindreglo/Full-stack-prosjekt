import axios from "axios";
axios.defaults.headers.common["Authorization"] =
  "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0ODkyMTE1NCwiaWF0IjoxNjQ4ODg1MTU0fQ.pkNJOIM7J5Du4oyOHaqxybFbaGxtbiG7yeY04mTy1us";

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
