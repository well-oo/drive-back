package car.ducrocqDrive.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class OrderCmd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdOn;

    private LocalDate deliveryDate;

    private int amount;

    private Status currentStatus;

    @OneToMany
    private List<ArticlesCart> articles;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<StatusHistory> histories;
}
