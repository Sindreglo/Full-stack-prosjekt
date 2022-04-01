export default function authHeader() {
  let jwt = JSON.parse(localStorage.getItem("jwt"));
  if (jwt) {
    return "Bearer " + jwt;
  } else {
    return {};
  }
}
