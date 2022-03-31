package oso.ntnu.idatt2015.backend.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "level")
@Getter @Setter @NoArgsConstructor
public class UserLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(unique = true)
    String UserLevel;

    public UserLevel(String userLevel){
        this.UserLevel = userLevel;
    }
}
