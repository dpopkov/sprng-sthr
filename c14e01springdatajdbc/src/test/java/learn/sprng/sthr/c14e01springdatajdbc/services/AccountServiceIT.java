package learn.sprng.sthr.c14e01springdatajdbc.services;

import learn.sprng.sthr.c14e01springdatajdbc.model.Account;
import learn.sprng.sthr.c14e01springdatajdbc.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@SpringBootTest
class AccountServiceIT {
    @MockBean
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;
    Account sender;
    Account receiver;

    @BeforeEach
    void setUp() {
        sender = new Account();
        sender.setId(1);
        sender.setAmount(BigDecimal.valueOf(1000));
        receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(BigDecimal.valueOf(1000));
    }

    @Test
    @DisplayName("The amount is transferred from sender to receiver")
    void transfer() {
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        accountService.transfer(sender.getId(), receiver.getId(), BigDecimal.valueOf(100));

        then(accountRepository).should().changeAmount(sender.getId(), BigDecimal.valueOf(900));
        then(accountRepository).should().changeAmount(receiver.getId(), BigDecimal.valueOf(1100));
    }
}
