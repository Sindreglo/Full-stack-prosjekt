package oso.ntnu.idatt2015.backend.model.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task_status")
@Getter @Setter @NoArgsConstructor
public class UseTaskStatus {
    @Id
    long id;
    @ManyToOne
    private Task task;

    private Boolean status;
}
