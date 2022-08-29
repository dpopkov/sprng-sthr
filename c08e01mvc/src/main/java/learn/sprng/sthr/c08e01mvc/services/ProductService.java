package learn.sprng.sthr.c08e01mvc.services;

import learn.sprng.sthr.c08e01mvc.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public synchronized void add(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }
}
