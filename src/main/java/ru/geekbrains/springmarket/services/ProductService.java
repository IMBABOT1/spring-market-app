package ru.geekbrains.springmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springmarket.entities.Product;
import ru.geekbrains.springmarket.repositories.InMemProductRepository;
import ru.geekbrains.springmarket.repositories.ProductDao;
import ru.geekbrains.springmarket.repositories.ProductDaoImpl;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productRepository;

    @Autowired
    public void setProductRepository(ProductDaoImpl productDao) {
        this.productRepository = productDao;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }


    public Product findProductById(Long id){
        return productRepository.findProductById(id);
    }

    public void deleteProductById(Long id){
        productRepository.deleteProductById(id);
    }

    public void changePrice(Long id, Integer delta) {
        Product p = productRepository.findProductById(id);
        p.setPrice(p.getPrice() + delta);
    }
}
