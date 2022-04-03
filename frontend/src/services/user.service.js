import axios from "axios";
import authHeader from "@/services/auth-header";
let apiClient = axios.create({
  baseURL: "http://localhost:8080/api/",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
    Authorization: authHeader(),
  },
});

class UserService {
  getUser() {
    return apiClient.get("user");
  }
}

export default new UserService();
