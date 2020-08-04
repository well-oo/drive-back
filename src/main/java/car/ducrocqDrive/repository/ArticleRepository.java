package car.ducrocqDrive.repository;

import car.ducrocqDrive.entity.Article;
import car.ducrocqDrive.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findArticlesByStockGreaterThan(int quantity);

    List<Article> findArticlesByCategoriesContainsAndStockGreaterThan(Category category, int quantity);

    @Query("SELECT DISTINCT a FROM Article a join a.categories c WHERE c.id in (?1) AND a.stock > 0")
    List<Article> findArticlesByCategoriesIdAndStockGreaterThan(List<Long> ids);
}
