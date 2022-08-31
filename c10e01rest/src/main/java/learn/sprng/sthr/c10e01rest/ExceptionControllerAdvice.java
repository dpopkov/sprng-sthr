package learn.sprng.sthr.c10e01rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails details = new ErrorDetails();
        details.setMessage("Not enough money to make the payment");
        return ResponseEntity
                .badRequest()
                .body(details);
    }
}
