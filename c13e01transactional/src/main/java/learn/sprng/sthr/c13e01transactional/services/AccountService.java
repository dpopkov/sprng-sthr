package learn.sprng.sthr.c13e01transactional.services;

import learn.sprng.sthr.c13e01transactional.model.Account;
import learn.sprng.sthr.c13e01transactional.repositories.AccountRepository;
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
        Account sender = accountRepository.findById(senderId);
        Account receiver = accountRepository.findById(receiverId);
        BigDecimal senderAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(senderId, senderAmount);
        if (senderAmount.compareTo(BigDecimal.ZERO) < 0) {
            // Imitating a problem during the use case to test transaction rollback
            throw new RuntimeException("Sender's amount cannot be negative");
        }
        accountRepository.changeAmount(receiverId, receiverAmount);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
