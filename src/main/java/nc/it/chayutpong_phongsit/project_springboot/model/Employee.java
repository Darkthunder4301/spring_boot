package nc.it.chayutpong_phongsit.project_springboot.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, tel;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Order> orders;

    public Employee(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
    


    
}
