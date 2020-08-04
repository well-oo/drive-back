package car.ducrocqDrive.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIgnoreProperties(value={ "cart" }, allowSetters= true)
public class ArticlesCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("cart")
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Article article;

    private int quantite;
}
