import axios from "axios";
import authHeader from "./auth-header";

let apiClient = axios.create({
  baseURL: "http://localhost:8080/api",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
    Authorization: authHeader(),
  },
});

export default {
  getSubjects() {
    return apiClient.get("/course");
  },
  async getSubject(id) {
    console.log(id + "???????");
    let res = await apiClient.get("/course/id", { params: { id: id } });
    return res;
  },
  postSubject(event) {
    return apiClient.post("/subjects", event);
  },
  getUsers() {
    return apiClient.get("/users");
  },
};
