package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.Category;
import car.ducrocqDrive.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Category>> findAllSorted(){
        return ResponseEntity.ok(categoryRepository.findAllByOrderByOrderIdx());
    }


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Category category){
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(category.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!categoryRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        categoryRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
