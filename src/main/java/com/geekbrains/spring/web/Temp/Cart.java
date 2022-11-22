package com.geekbrains.spring.web.Temp;

import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.ProductsService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.IScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
@AllArgsConstructor
public class Cart {

    private final ProductsService productsService;

    private List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public void addProduct(Long id) {
        Optional<Product> product = productsService.findById(id);
        if (product.isPresent()) {
            products.add(product.get());
        } else {
            throw new ResourceNotFoundException("Product not found, id: " + id);
        }
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }
}
