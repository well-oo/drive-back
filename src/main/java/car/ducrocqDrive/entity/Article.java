package car.ducrocqDrive.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "article_type",discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = Product.class, name = "Product" ), @JsonSubTypes.Type(value = Perishable.class, name = "Perishable" )})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ean13;

    private int price;

    private double vat;

    private String name;

    private String img;

    private int stock;

    @ManyToMany
    private List<Category> categories;
}
