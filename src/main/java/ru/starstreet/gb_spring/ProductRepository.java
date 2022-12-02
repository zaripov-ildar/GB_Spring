package ru.starstreet.gb_spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i + 1, "Product #" + (i + 1), rnd.nextInt(500)));
        }
    }

    public List<Product> getProductList() {
        return products;
    }

    public Product getProductById(long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no such number " + id));
    }
}
