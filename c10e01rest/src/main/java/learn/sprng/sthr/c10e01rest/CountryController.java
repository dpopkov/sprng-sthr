package learn.sprng.sthr.c10e01rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/china")
    public ResponseEntity<Country> china() {
        Country country = Country.of("China", 1_000);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Continent", "Asia")
                .header("Capital", "Beijing")
                .body(country);
    }

    @GetMapping("/all")
    public Collection<Country> all() {
        return List.of(
                Country.of("China", 1_412),
                Country.of("India", 1_375)
        );
    }
}
