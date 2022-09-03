package learn.sprng.sthr.c13e01transactional.controllers;

import learn.sprng.sthr.c13e01transactional.model.Account;
import learn.sprng.sthr.c13e01transactional.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequestDto transferRequest) {
        accountService.transfer(transferRequest.getSenderId(),
                                transferRequest.getReceiverId(),
                                transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }
}
