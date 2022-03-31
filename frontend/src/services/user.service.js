import axios from "axios";
import authHeader from "@/services/auth-header";
const API_URL = "http://localhost:8080/api/test/";
class UserService {
  getAll() {
    return axios.get(API_URL + "all");
  }
  getUserBoard() {
    return axios.get(API_URL + "user", { headers: authHeader() });
  }
  getStudassBoard() {
    return axios.get(API_URL + "studass", { headers: authHeader() });
  }
  getProfessorBoard() {
    return axios.get(API_URL + "professor", { headers: authHeader() });
  }
}
export default new UserService();
