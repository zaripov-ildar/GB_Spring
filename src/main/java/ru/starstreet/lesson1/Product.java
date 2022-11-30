package ru.starstreet.lesson1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String title;
    private int coast;

    public static Product getRandomProduct() {
        Random rnd = new Random();
        long id = rnd.nextInt(50);
        return new Product(id, "Product #" + id, rnd.nextInt(100));
    }
}
