package ru.starstreet.gb_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.starstreet.gb_spring");
        ProductRepository repository = context.getBean(ProductRepository.class);
        System.out.println("Goods in the repository");
        repository.getProductList().forEach(System.out::println);

        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "exit" -> System.exit(0);
                case "add" -> cart.add(Long.parseLong(tokens[1]));
                case "remove" -> cart.remove(Long.parseLong(tokens[1]));
                case "clean" -> cart.clean();
                case "show" -> cart.show();
                default -> {
                    System.out.println("Wrong command");
                    System.out.println("Examples of input:\n" +
                            "\texit\n" +
                            "\tadd ID_NUMBER\n" +
                            "\tremove ID_NUMBER\n" +
                            "\tclean\n" +
                            "\tshow\n"
                    );
                }
            }
        }
    }
}
