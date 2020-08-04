package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.ArticlesCart;
import car.ducrocqDrive.repository.ArticlesCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articlesCart")
@Slf4j
public class ArticlesCartController {

    @Autowired
    private ArticlesCartRepository articlesCartRepository;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ArticlesCart articlesCart){
        Optional<ArticlesCart> articlesCartOptional = articlesCartRepository.findByCartAndArticle(articlesCart.getCart(), articlesCart.getArticle());
        if(articlesCartOptional.isPresent()){
            ArticlesCart ac = articlesCartOptional.get();
            ac.setQuantite(ac.getQuantite() + articlesCart.getQuantite());
            return ResponseEntity.ok(articlesCartRepository.save(ac));
        }else {
            return ResponseEntity.ok(articlesCartRepository.save(articlesCart));
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateQuantity(@Valid @RequestBody ArticlesCart articlesCart){
        Optional<ArticlesCart> articlesCartOptional = articlesCartRepository.findByCartAndArticle(articlesCart.getCart(), articlesCart.getArticle());
        if(articlesCartOptional.isPresent()){
            ArticlesCart ac = articlesCartOptional.get();
            ac.setQuantite(articlesCart.getQuantite());
            return ResponseEntity.ok(articlesCartRepository.save(ac));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ArticlesCart>> findAll(){
        return ResponseEntity.ok(articlesCartRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!articlesCartRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        articlesCartRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
