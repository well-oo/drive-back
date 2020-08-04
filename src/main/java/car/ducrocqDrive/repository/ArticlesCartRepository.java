package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.Article;
import car.ducrocqDrive.entity.ArticlesCart;
import car.ducrocqDrive.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticlesCartRepository extends JpaRepository<ArticlesCart,Long> {

    Optional<ArticlesCart> findByCartAndArticle(Cart cart, Article article);

}
