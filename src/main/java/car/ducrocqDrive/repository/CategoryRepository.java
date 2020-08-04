package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByOrderIdx();
}
