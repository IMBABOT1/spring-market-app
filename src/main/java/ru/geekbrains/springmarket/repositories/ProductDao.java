package ru.geekbrains.springmarket.repositories;

import ru.geekbrains.springmarket.entities.Product;

import java.util.List;

public interface ProductDao {

    Product findProductById(Long id);
    void deleteProductById(Long id);
    List<Product> findAll();

    Product saveOrUpdate(Product product);
}
