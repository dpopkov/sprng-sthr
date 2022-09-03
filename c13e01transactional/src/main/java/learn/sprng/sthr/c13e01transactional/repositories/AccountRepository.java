package learn.sprng.sthr.c13e01transactional.repositories;

import learn.sprng.sthr.c13e01transactional.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findById(Integer id) {
        String sql = "SELECT id, name, amount FROM account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(Integer id, BigDecimal newAmount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, newAmount, id);
    }

    public List<Account> findAll() {
        String sql = "SELECT id, name, amount FROM account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
