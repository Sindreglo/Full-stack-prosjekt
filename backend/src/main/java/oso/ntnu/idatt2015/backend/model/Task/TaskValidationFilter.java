package oso.ntnu.idatt2015.backend.model.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "validation_filter")
@Getter @Setter @NoArgsConstructor
public class TaskValidationFilter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    //layout: 1-3,2;4-6,3;....
    String filter;

    @OneToMany
    @JoinColumn(name = "validation_filter_id", referencedColumnName = "id")
    private List<QCourse> courses;

    public TaskValidationFilter(String filter){
        this.filter = filter;
    }

    public boolean isValid(){
        if (!filter.contains(";")){
            return false;
            //return approved()>=Integer.parseInt(filter);
        }
        String[] filters = filter.split(";");

        for (int i = 0; i < filters.length; i++) {
            String[] reFilter = filters[i].split(",");
            int amount = Integer.parseInt(reFilter[1]);
            int start = Integer.parseInt(reFilter[0].split("-")[0]);
            int stop = Integer.parseInt(reFilter[0].split("-")[1]);
            for (int j = start; i>stop; i++){
                amount -= 1;
            }
            if (amount>0){
                return false;
            }
        }
        return true;
    }

    private boolean approved() {
        //find approved
        return true;
    }
}

