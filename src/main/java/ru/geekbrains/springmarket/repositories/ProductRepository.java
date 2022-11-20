package ru.geekbrains.springmarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springmarket.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
