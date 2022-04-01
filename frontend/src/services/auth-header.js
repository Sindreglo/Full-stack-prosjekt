export default function authHeader() {
  let jwt = JSON.parse(localStorage.getItem("jwt"));
  if (jwt) {
    return { Authorization: "Bearer " + jwt };
  } else {
    return {};
  }
}
