package oso.ntnu.idatt2015.backend.model.Security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AuthenticationResponse {
    String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
