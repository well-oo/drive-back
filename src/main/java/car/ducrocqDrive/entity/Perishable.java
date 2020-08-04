package car.ducrocqDrive.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Perishable")
public class Perishable extends Article {

    private LocalDate bestBefore;

    private String lot;
}
