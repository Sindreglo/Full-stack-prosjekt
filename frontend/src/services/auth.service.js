import axios from "axios";
const API_URL = "http://localhost:8080/api/auth/";
class AuthService {
  login(user) {
    return axios
      .post(API_URL + "login", {
        username: user.username,
        password: user.password,
      })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }
        return response.data;
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
