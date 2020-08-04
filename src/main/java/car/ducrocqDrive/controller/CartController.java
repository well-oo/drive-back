package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.Cart;
import car.ducrocqDrive.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@Slf4j
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public ResponseEntity<List<Cart>> findAll(){
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Cart cart){
        cart.setCreatedOn(LocalDate.now());
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> update(@PathVariable Long id, @Valid @RequestBody Cart cart) {
        if (!cartRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cartRepository.save(cart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cart.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!cartRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        cartRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }



}
