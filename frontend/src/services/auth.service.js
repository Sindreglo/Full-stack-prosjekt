import axios from "axios";
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
  login2(user) {
    axios
      .post(API_URL, { username: user.username, password: user.password })
      .then((r) => {
        console.log(r.data);
        if (r.data.jwt) {
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
