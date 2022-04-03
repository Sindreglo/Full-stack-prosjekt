import axios from "axios";
import store from "@/store";
const API_URL = "http://localhost:8080/auth";

/**
 * const apiClient = axios.create({
 *   baseURL: "http://localhost:8080/auth",
 *   withCredentials: false,
 *   headers: {
 *     Accept: "application/json",
 *     "Content-Type": "application/json",
 *   },
 * });
 */

class AuthService {
  login(user) {
    axios
      .post(API_URL, { username: user.username, password: user.password })
      .then((r) => {
        if (r.data === "Incorrect username or password line 43") {
          console.log("FEIL");
        }
        if (r.data.jwt) {
          store.commit("SET_LEVEL", 2);
          localStorage.setItem("jwt", JSON.stringify(r.data.jwt));
        }
      });
  }
  logout() {
    localStorage.removeItem("user");
  }
  //Vi trenger vel egt ikke denne her
  register(user) {
    return axios.post(API_URL + "signup", {
      username: user.username,
      password: user.password,
    });
  }
}
export default new AuthService();
