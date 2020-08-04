package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
