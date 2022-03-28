package oso.ntnu.idatt2015.backend.model;

public class LoginReply {
    String jwt;

    public LoginReply(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
