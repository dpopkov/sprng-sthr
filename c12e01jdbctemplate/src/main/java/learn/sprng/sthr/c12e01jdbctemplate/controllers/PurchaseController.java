package learn.sprng.sthr.c12e01jdbctemplate.controllers;

import learn.sprng.sthr.c12e01jdbctemplate.model.Purchase;
import learn.sprng.sthr.c12e01jdbctemplate.repositories.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void savePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> findAllPurchases() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchaseRepository.findAll());
    }
}
