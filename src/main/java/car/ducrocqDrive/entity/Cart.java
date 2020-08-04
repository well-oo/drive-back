package car.ducrocqDrive.entity;


import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdOn;

    @OneToMany(mappedBy = "cart")
    private List<ArticlesCart> articlesCart;

    @ManyToOne
    private Customer customer;
}
