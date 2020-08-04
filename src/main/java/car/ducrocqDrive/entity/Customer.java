package car.ducrocqDrive.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data

public class Customer {

    @Id
    private String login;

    private String firstName;

    private String lastName;

    private String email;

    @Column(name="PASSWORD", updatable=false)
    private String password;

    @OneToOne
    private Cart activeCart;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

}
