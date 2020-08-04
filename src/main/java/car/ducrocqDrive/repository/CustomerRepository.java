package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

     Optional<Customer> findByLoginAndPassword(String login, String password);
}
