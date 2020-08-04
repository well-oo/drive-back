package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.Article;
import car.ducrocqDrive.entity.Category;
import car.ducrocqDrive.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<Article>> findAllInStock(){
        return ResponseEntity.ok(articleRepository.findArticlesByStockGreaterThan(0));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Article article){
        return ResponseEntity.ok(articleRepository.save(article));
    }


    @PostMapping("/category")
    public ResponseEntity findByCategory(@Valid @RequestBody Category category){
        return ResponseEntity.ok(articleRepository.findArticlesByCategoriesContainsAndStockGreaterThan(category,0));
    }


    @PostMapping("/categories")
    public ResponseEntity findByCategory(@Valid @RequestBody List<Long> ids){
        return ResponseEntity.ok(articleRepository.findArticlesByCategoriesIdAndStockGreaterThan(ids));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @Valid @RequestBody Article article) {
        if (!articleRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(articleRepository.save(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (!article.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(article.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!articleRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        articleRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
