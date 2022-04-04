package oso.ntnu.idatt2015.backend.model.HTTP;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IdRequest {
    Long id;

    public IdRequest(Long id){
        this.id = id;
    }
}
