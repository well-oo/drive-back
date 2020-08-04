package car.ducrocqDrive.controller;


import car.ducrocqDrive.entity.*;
import car.ducrocqDrive.repository.ArticleRepository;
import car.ducrocqDrive.repository.CartRepository;
import car.ducrocqDrive.repository.CustomerRepository;
import car.ducrocqDrive.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping
    public ResponseEntity<List<OrderCmd>> findAll(){
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody OrderCmd order){
        //verification du stock de chaque produit
        boolean stockGood = order.getArticles().stream().allMatch(articlesCart -> articlesCart.getArticle().getStock() >= articlesCart.getQuantite());
        if(!stockGood){
            return ResponseEntity.badRequest().build();
        }
        order.setCreatedOn(LocalDate.now());
        long leftLimit = 1L;
        long rightLimit = 15L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        order.setDeliveryDate(LocalDate.now().plusDays(generatedLong));
        order.setCurrentStatus(Status.ORDERED);
        //on détermine le prix de la commande et on diminue les stocks
        Optional<Integer> amount = order.getArticles().stream().map(a -> {
            Article article = a.getArticle();
            article.setStock(article.getStock() - a.getQuantite());
            articleRepository.save(article);
            return a.getArticle().getPrice() * a.getQuantite();
        }).reduce((x,y)-> x+ y);
        order.setAmount(amount.get());

        //gestion du nouveau panier
        Cart newCart = new Cart();
        newCart.setCreatedOn(LocalDate.now());
        newCart.setArticlesCart(new ArrayList<>());
        cartRepository.save(newCart);
        order.getCustomer().getActiveCart().setCustomer(order.getCustomer());
        cartRepository.save(order.getCustomer().getActiveCart());
        order.getCustomer().setActiveCart(newCart);
        orderRepository.save(order);

        return ResponseEntity.ok(customerRepository.save(order.getCustomer()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCmd> findById(@PathVariable Long id) {
        Optional<OrderCmd> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(order.get());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderCmd>> findByUserId(@PathVariable String id) {
        return ResponseEntity.ok(orderRepository.findAllByCustomer_Login(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCmd> update(@PathVariable Long id, @Valid @RequestBody OrderCmd order) {
        if (!orderRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(orderRepository.save(order));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!orderRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        orderRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
