package learn.sprng.sthr.c14e01springdatajdbc.repositories;

import learn.sprng.sthr.c14e01springdatajdbc.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    // Query method relying on Spring Data translating
    List<Account> findAccountsByName(String name);

    // SQL query
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(Integer id, BigDecimal amount);
}
