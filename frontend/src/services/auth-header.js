export default function authHeader() {
  let user = JSON.parse(localStorage.getItem("user"));
  if (user && user.accessToken) {
    //BEARERERERERERERER
    return { Authorization: "Bearer " + user.accessToken };
  } else {
    return {};
  }
}
