package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.Customer;
import car.ducrocqDrive.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customer.get());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Customer> authenticateUser(@RequestBody Customer customer){
        Optional<Customer> user = customerRepository.findByLoginAndPassword(customer.getLogin(), customer.getPassword());
        if (!user.isPresent()) {
            log.error("Login or password inccorect");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable String id, @Valid @RequestBody Customer customer) {
        Optional<Customer> c = customerRepository.findById(id);
        if (!c.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!customerRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        customerRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
