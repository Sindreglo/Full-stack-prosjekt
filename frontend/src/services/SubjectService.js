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

const url = "http://localhost:8080/api/course";
const options = {
  method: "GET",
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json;charset=UTF-8",
    Authorization: authHeader(),
  },
};

export default {
  getSubjects() {
    fetch(url, options)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      });
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
