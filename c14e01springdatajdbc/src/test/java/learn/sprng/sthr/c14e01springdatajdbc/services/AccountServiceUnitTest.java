package learn.sprng.sthr.c14e01springdatajdbc.services;

import learn.sprng.sthr.c14e01springdatajdbc.model.Account;
import learn.sprng.sthr.c14e01springdatajdbc.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceUnitTest {
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
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

    @Test
    @DisplayName("Transfer fails when no account id found")
    void transferFailsWhenNoAccount() {
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.empty());

        Assertions.assertThrows(AccountNotFoundException.class,
                () -> accountService.transfer(sender.getId(), receiver.getId(), BigDecimal.valueOf(100)));

        then(accountRepository).should(never()).changeAmount(any(Integer.class), any(BigDecimal.class));
    }
}
