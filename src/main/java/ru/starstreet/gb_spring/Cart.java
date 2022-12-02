package ru.starstreet.gb_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository repository;
    private List<Product> productList;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void init() {
        productList = new ArrayList<>();
    }

    public void add(long id) {
        productList.add(repository.getProductById(id));
    }

    public void remove(long id){
        productList = productList.stream()
                .filter(product -> product.getId()!=id)
                .collect(Collectors.toList());
    }

    public void clean() {
        productList.clear();
    }

    public void show() {
        productList.forEach(System.out::println);
    }
}
