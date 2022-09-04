package learn.sprng.sthr.c14e01springdatajdbc.controller;

import learn.sprng.sthr.c14e01springdatajdbc.model.Account;
import learn.sprng.sthr.c14e01springdatajdbc.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(@RequestParam(required = false) String name) {
        if (name == null) {
            return accountService.getAllAccounts();
        } else {
            return accountService.findAccountsByName(name);
        }
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request) {
        accountService.transfer(request.getSenderId(),
                                request.getReceiverId(),
                                request.getAmount());
    }
}
