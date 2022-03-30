package oso.ntnu.idatt2015.backend.model.HTTP;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.User.QUser;

@Getter @Setter @NoArgsConstructor
public class UserResponse {
    private QUser username;

    public UserResponse(QUser username){
        this.username = username;
    }
}
