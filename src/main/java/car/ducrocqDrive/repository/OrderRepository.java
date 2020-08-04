package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.OrderCmd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderCmd, Long> {

    List<OrderCmd> findAllByCustomer_Login(String login);
}
