package ru.geekbrains.springmarket.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springmarket.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class ProductRepository {


    private List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Demon Souls", 80),
                new Product(2L, "Dark Souls", 80),
                new Product(3L, "Dark Souls 2", 80),
                new Product(4L, "Dark Souls 3", 80),
                new Product(5L, "BloodBorne", 80)
        ));
    }


    public Product findProductById(Long id){
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product with id: " + id + "not found");
    }

    public void deleteProductById(Long id) {
        for (Product p : products){
            if (p.getId() == id){
                products.remove(p);
                return;
            }
        }
        throw new RuntimeException("Product with id: " + id + " not found");
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }
}
