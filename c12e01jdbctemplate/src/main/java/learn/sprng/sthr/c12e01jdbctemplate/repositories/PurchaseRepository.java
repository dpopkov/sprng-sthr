package learn.sprng.sthr.c12e01jdbctemplate.repositories;

import learn.sprng.sthr.c12e01jdbctemplate.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) { // The warning 'Could not autowire' can be ignored here.
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Purchase purchase) {
        final String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> findAll() {
        final String sql = "SELECT id, product, price FROM purchase";
        final RowMapper<Purchase> rowMapper = (resultSet, i) -> {
            Purchase p = new Purchase();
            p.setId(resultSet.getInt("id"));
            p.setProduct(resultSet.getString("product"));
            p.setPrice(resultSet.getBigDecimal("price"));
            return p;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}
