package car.ducrocqDrive.controller;

import car.ducrocqDrive.entity.Article;
import car.ducrocqDrive.entity.StatusHistory;
import car.ducrocqDrive.repository.ArticleRepository;
import car.ducrocqDrive.repository.StatusHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/histories")
@Slf4j
public class StatusHistoryController {

    @Autowired
    private StatusHistoryRepository statusHistoryRepository;

    @GetMapping
    public ResponseEntity<List<StatusHistory>> findAll(){
        return ResponseEntity.ok(statusHistoryRepository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody StatusHistory statusHistory){
        return ResponseEntity.ok(statusHistoryRepository.save(statusHistory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusHistory> findById(@PathVariable Long id) {
        Optional<StatusHistory> statusHistory = statusHistoryRepository.findById(id);
        if (!statusHistory.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(statusHistory.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusHistory> update(@PathVariable Long id, @Valid @RequestBody StatusHistory statusHistory) {
        if (!statusHistoryRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(statusHistoryRepository.save(statusHistory));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!statusHistoryRepository.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        statusHistoryRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
