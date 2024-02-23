package nc.it.chayutpong_phongsit.project_springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties({"hibernatelazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, author;
    private double price;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Order> orders;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
