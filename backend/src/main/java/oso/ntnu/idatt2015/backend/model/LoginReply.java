package oso.ntnu.idatt2015.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginReply {
    String jwt;

    public LoginReply(String jwt) {
        this.jwt = jwt;
    }

}
