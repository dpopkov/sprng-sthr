package learn.sprng.sthr.c14e01springdatajdbc.services;

import learn.sprng.sthr.c14e01springdatajdbc.model.Account;
import learn.sprng.sthr.c14e01springdatajdbc.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Integer senderId, Integer receiverId, BigDecimal amount) {
        Account sender = accountRepository.findById(senderId).orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository.findById(receiverId).orElseThrow(AccountNotFoundException::new);
        BigDecimal senderAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(senderId, senderAmount);
        accountRepository.changeAmount(receiverId, receiverAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findByName(name);
    }
}
